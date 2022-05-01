package com.skyspecs.task2.controller;

import com.skyspecs.task2.service.SemoDispatchDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/csv")
public class LoadFromCsvController {

    @Autowired
    private SemoDispatchDownService semoDispatchDownService;

    @GetMapping("/load")
    public ResponseEntity loadFromCsv(){
        return new ResponseEntity(semoDispatchDownService.saveAll(), HttpStatus.ACCEPTED);
    }
}
