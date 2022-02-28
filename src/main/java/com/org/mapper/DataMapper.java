package com.org.mapper;

import com.org.dto.DataDto;
import com.org.entity.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DataMapper {


    public static Data map(DataDto dataDto) {

        Data data = new Data();
        data.setCreatedAt(convertEpoch(dataDto.getCreatedAtUnix()));
        data.setDynamicValueType(dataDto.getDynamicValueType());
        data.setEndTimestamp(convertEpoch(dataDto.getEndTimestampUnix()));
        data.setStartTimestamp(convertEpoch(dataDto.getStartTimestampUnix()));
        data.setValue(dataDto.getValue());
        data.setValueType(dataDto.getValueType());

        return data;
    }

    private static LocalDate convertEpoch(long epoch) {
        return
                Instant.ofEpochMilli(epoch).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static List<DataDto> toDto(List<Data> dataList) {

        List<DataDto> dataDtoList = new ArrayList<>();
        for (Data data : dataList) {
            DataDto dto = new DataDto();
            //  dto.getCreatedAtUnix(LocalDate.());
        }
        return dataDtoList;
    }
}
