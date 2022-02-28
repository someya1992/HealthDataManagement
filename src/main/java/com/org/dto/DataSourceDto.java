package com.org.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataSourceDto {

    private String dataSource;
    private List<DataDto> data;

}
