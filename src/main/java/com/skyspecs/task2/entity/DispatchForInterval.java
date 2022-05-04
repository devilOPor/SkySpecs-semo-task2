package com.skyspecs.task2.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DispatchForInterval {
    private Timestamp startTime;
    private Timestamp endTime;
    private Double avgQboa;
}
