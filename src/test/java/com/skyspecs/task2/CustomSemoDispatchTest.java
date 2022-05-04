package com.skyspecs.task2;


import com.skyspecs.task2.repo.CustomSemoDispatchDownRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomSemoDispatchTest {

    @Autowired
    private CustomSemoDispatchDownRepo customSemoDispatchDownRepo;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void IntervalTest() {
        assertEquals(customSemoDispatchDownRepo.electricityGenerated().get(0).getAvgQboa(),31.0);
    }

}
