package com.skyspecs.task2.repo;

import com.skyspecs.task2.entity.SemoDispatchDownEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemoDispatchDownRepo extends JpaRepository<SemoDispatchDownEntity, Long> {
}
