package com.org.controller;

import com.org.dto.DataDto;
import com.org.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.OptionalDouble;

@RestController
public class DataController {

    @Autowired
    private DataService dataService;


    @PostMapping("/userData/{path}")
    public ResponseEntity userData(@PathVariable String path) throws IOException, InterruptedException {
        dataService.userData(path);
        return ResponseEntity.ok("");
    }

    @GetMapping("heartrate/{userId}")
    public ResponseEntity<Double> averageHeartRate(@PathVariable String userId) {
        OptionalDouble average = dataService.averageHeartRate(userId);
        return ResponseEntity.ok(average.orElse(0.0));
    }

    @GetMapping("userData/{userId}")
    public ResponseEntity<List<DataDto>> data(@PathVariable String userId) {
        List<DataDto> dataList = dataService.data(userId);
        return ResponseEntity.ok(dataList);
    }


}
