package com.skyspecs.task2;

import com.skyspecs.task2.repo.AppRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppReoTest {

    @Autowired
    AppRepository appRepository;

    @Test
    void csvTest(){
        appRepository.loadFromCsv();
    }
}
