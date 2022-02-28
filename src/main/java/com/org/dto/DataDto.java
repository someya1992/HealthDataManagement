package com.org.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataDto {

    private long startTimestampUnix;
    private long endTimestampUnix;
    private long createdAtUnix;
    private String dynamicValueType;
    private String value;
    private String valueType;
}
