package com.skyspecs.task2.service;

import com.skyspecs.task2.entity.SemoDispatchDownEntity;
import com.skyspecs.task2.repo.AppRepository;
import com.skyspecs.task2.repo.SemoDispatchDownRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SemoDispatchDownService {

    @Autowired
    SemoDispatchDownRepo semoDispatchDownRepo;

    @Autowired
    AppRepository appRepository;

    public List<SemoDispatchDownEntity> saveAll(){
        List<SemoDispatchDownEntity> semoDispatchDownEntities =  appRepository.loadFromCsv();
       return semoDispatchDownRepo.saveAll(semoDispatchDownEntities);
    }

    public List<SemoDispatchDownEntity> fetchAll(){
        return semoDispatchDownRepo.findAll();
    }
}
