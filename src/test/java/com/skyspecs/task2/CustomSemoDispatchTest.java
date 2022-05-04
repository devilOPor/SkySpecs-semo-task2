package com.skyspecs.task2;

import com.skyspecs.task2.entity.DispatchForInterval;
import com.skyspecs.task2.repo.CustomSemoDispatchDownRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CustomSemoDispatchTest {

    @Autowired
    private CustomSemoDispatchDownRepo customSemoDispatchDownRepo;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void IntervalTest() {
        customSemoDispatchDownRepo.electricityGenerated();
    }

    @Test
    public void jpql() {
        Query query = entityManager.createQuery("select p.startTime,p.endTime,avg(qboa) from SemoDispatchDownEntity p" +
                " group by p.startTime ,p.endTime having count(startTime)>1 order by p.startTime");
        List<Object[]> results = query.getResultList();
        List<DispatchForInterval> dispatchList = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < results.size(); i=i+6) {
            Timestamp startTime = (Timestamp) results.get(i)[0];
            Timestamp endTime = null;
            DispatchForInterval dispatchForInterval = new DispatchForInterval();
            Double qboa = 0.0;
            for(int j=0;j < 7 && j< results.size()-i;j++){
                qboa = qboa+Double.parseDouble(results.get(i+j)[2].toString());
                endTime = (Timestamp) results.get(i+j)[0];
            }
            dispatchForInterval.setAvgQboa(qboa);
            dispatchForInterval.setEndTime(endTime);
            dispatchForInterval.setStartTime(startTime);
            dispatchList.add(dispatchForInterval);
        }

        System.out.println(dispatchList);
        int i=0;
        for(DispatchForInterval dispatchForInterval : dispatchList){
            System.out.println( ++i +"  "+ dispatchForInterval);
        }
    }
}
