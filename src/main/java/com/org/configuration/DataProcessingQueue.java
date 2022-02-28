package com.org.configuration;


import com.org.dto.RootDataDto;

import java.util.concurrent.LinkedBlockingQueue;

public class DataProcessingQueue {

    private static final LinkedBlockingQueue<RootDataDto> dataProcessingQueue = new LinkedBlockingQueue<>();

    public static LinkedBlockingQueue<RootDataDto> getDataLinkedBlockingQueue() {
        return dataProcessingQueue;
    }

}
