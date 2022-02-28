package com.org.service;

import com.org.configuration.DataProcessingQueue;
import com.org.dto.DataDto;
import com.org.dto.DataSourceDto;
import com.org.dto.RootDataDto;
import com.org.entity.Data;
import com.org.mapper.DataMapper;
import com.org.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

@Component
public class DataProcessor {

    @Autowired
    private DataRepository dataRepository;

    LinkedBlockingQueue<RootDataDto> rootDataQueue = DataProcessingQueue.getDataLinkedBlockingQueue();

    @Scheduled(fixedRate = 1000, initialDelay = 4000)
    public void process() {

        while (!rootDataQueue.isEmpty()) {
            RootDataDto rootDataDto = rootDataQueue.poll();
            DataSourceDto dataSourceDto = rootDataDto.getDataSources().get(0);
            String userId = dataSourceDto.getDataSource();
            for (DataDto dataDto : dataSourceDto.getData()) {
                Data data = DataMapper.map(dataDto);
                data.setUserId(userId);
                dataRepository.save(data);
            }
        }
    }
}
