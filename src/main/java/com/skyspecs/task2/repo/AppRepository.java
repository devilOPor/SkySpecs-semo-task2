package com.skyspecs.task2.repo;

import com.skyspecs.task2.entity.SemoDispatchDownEntity;

import java.util.List;

public interface AppRepository {

    List<SemoDispatchDownEntity> loadFromCsv();
}
