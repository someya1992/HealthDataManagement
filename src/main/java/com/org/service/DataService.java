package com.org.service;

import com.org.dto.DataDto;
import com.org.entity.Data;
import com.org.mapper.DataMapper;
import com.org.repository.DataRepository;
import com.org.utility.DataUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.OptionalDouble;

@Service
public class DataService {

    @Autowired
    private DataUtility dataUtility;

    @Autowired
    private DataRepository dataRepository;

    public void userData(String path) throws IOException, InterruptedException {
        dataUtility.parseHealthData(path);
    }


    public OptionalDouble averageHeartRate(String userId) {
        List<Data> dataList = dataRepository.findByUserId(userId);
        return dataList.stream().mapToDouble(data -> Double.parseDouble(data.getValue())).average();

    }

    public List<DataDto> data(String userId) {
        return DataMapper.toDto(dataRepository.findByUserId(userId));
    }
}
