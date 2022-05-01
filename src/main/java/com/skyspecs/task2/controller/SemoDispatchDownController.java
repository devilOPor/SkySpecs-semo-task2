package com.skyspecs.task2.controller;

import com.skyspecs.task2.service.SemoDispatchDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;

@RestController
@RequestMapping("api/dispatch")
public class SemoDispatchDownController {

    @Autowired
    SemoDispatchDownService semoDispatchDownService;

    @GetMapping("/all")
    public ResponseEntity fetchAll(){
        return new ResponseEntity(semoDispatchDownService.fetchAll(), HttpStatus.OK);
    }
}
