package com.org.utility;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.org.configuration.DataProcessingQueue;
import com.org.dto.RootDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class DataUtility {

    @Autowired
    ResourceLoader resourceLoader;

    public void parseHealthData(String path) throws IOException, InterruptedException {

        Resource resource = resourceLoader.getResource(path);

        try (
                InputStream inputStream = resource.getInputStream();
                JsonReader reader = new JsonReader(new InputStreamReader(inputStream))
        ) {
            reader.beginArray();
            while (reader.hasNext()) {
                RootDataDto rootDataDto = new Gson().fromJson(reader, RootDataDto.class);
                DataProcessingQueue.getDataLinkedBlockingQueue().put(rootDataDto);

            }
            reader.endArray();
        }
    }

}



