package com.org.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class RootDataDto {

    private int authenticationToken;
    private ArrayList<DataSourceDto> dataSources;

}
