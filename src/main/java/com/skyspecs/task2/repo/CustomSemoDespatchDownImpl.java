package com.skyspecs.task2.repo;

import com.skyspecs.task2.entity.SemoDispatchDownEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

@Repository
public class CustomSemoDespatchDownImpl implements CustomSemoDispatchDownRepo{

    @Autowired
    private EntityManager entityManager;

    public void electricityGenerated(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SemoDispatchDownEntity> criteria = criteriaBuilder.createQuery(SemoDispatchDownEntity.class);
        Root<SemoDispatchDownEntity> root = criteria.from(SemoDispatchDownEntity.class);
        criteria.multiselect(root.get("startTime"),root.get("endTime"));
//        List<Predicate> restrictions = new ArrayList<>();
//        Expression<Long> expr = criteriaBuilder.count(root.get("startTime"));
//
//        restrictions.add(criteriaBuilder.greaterThan(expr, criteriaBuilder.countDistinct(root.get("startTime"))));
//        criteria.where(restrictions.toArray(new Predicate[restrictions.size()]));
        TypedQuery query = entityManager.createQuery(criteria);
        List<Object[]> result = query.getResultList();
//        System.out.println(result);
    }
}


//select start_time,end_time,avg(qboa) from semo_dispatch_down group by start_time ,end_time having count(start_time)>1 order by start_time;