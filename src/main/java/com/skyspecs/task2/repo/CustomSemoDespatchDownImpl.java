package com.skyspecs.task2.repo;

import com.skyspecs.task2.entity.DispatchForInterval;
import com.skyspecs.task2.entity.SemoDispatchDownEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomSemoDespatchDownImpl implements CustomSemoDispatchDownRepo{

    @Autowired
    private EntityManager entityManager;

    public List<DispatchForInterval> electricityGenerated(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);
        Root<SemoDispatchDownEntity> root = criteria.from(SemoDispatchDownEntity.class);
        criteria.multiselect(root.get("startTime"),root.get("endTime")
                ,criteriaBuilder.avg(root.get("qboa")));
        criteria.groupBy(root.get("startTime"),root.get("endTime"));
        criteria.having(criteriaBuilder.greaterThan(criteriaBuilder.count(root.get("startTime")),
                (criteriaBuilder.countDistinct(root.get("startTime")))));
        criteria.orderBy(criteriaBuilder.asc(root.get("startTime")));
        TypedQuery<Object[]> query = entityManager.createQuery(criteria);
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
        return dispatchList;
    }

}


//select start_time,end_time,avg(qboa) from semo_dispatch_down group by start_time ,end_time having count(start_time)>1 order by start_time;