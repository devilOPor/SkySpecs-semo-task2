package com.skyspecs.task2;

import com.skyspecs.task2.repo.CustomSemoDispatchDownRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomSemoDispatchTest {

    @Autowired
    CustomSemoDispatchDownRepo customSemoDispatchDownRepo;

    @Test
    public void IntervalTest(){
        customSemoDispatchDownRepo.electricityGenerated();
    }
}
