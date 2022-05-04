package com.skyspecs.task2.service;

import com.skyspecs.task2.entity.DispatchForInterval;
import com.skyspecs.task2.entity.SemoDispatchDownEntity;
import com.skyspecs.task2.repo.AppRepository;
import com.skyspecs.task2.repo.CustomSemoDispatchDownRepo;
import com.skyspecs.task2.repo.SemoDispatchDownRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemoDispatchDownService {

    @Autowired
    private SemoDispatchDownRepo semoDispatchDownRepo;

    @Autowired
    private AppRepository appRepository;

    @Autowired
    private CustomSemoDispatchDownRepo customSemoDispatchDownRepo;

    public List<SemoDispatchDownEntity> saveAll(){
        List<SemoDispatchDownEntity> semoDispatchDownEntities =  appRepository.loadFromCsv();
       return semoDispatchDownRepo.saveAll(semoDispatchDownEntities);
    }

    public List<SemoDispatchDownEntity> fetchAll(){
        return semoDispatchDownRepo.findAll();
    }

    public List<DispatchForInterval> fetchDispatchFor30min(){
        return  customSemoDispatchDownRepo.electricityGenerated();
    }
}
