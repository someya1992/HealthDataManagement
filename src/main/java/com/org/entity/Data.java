package com.org.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Data")
@Setter
@Getter
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "start_timestamp", columnDefinition = "DATE")
    private LocalDate startTimestamp;

    @Column(name = "end_timestamp", columnDefinition = "DATE")
    private LocalDate endTimestamp;

    @Column(name = "created_timestamp", columnDefinition = "DATE")
    private LocalDate createdAt;

    @Column(name = "dynamicValueType")
    private String dynamicValueType;

    @Column(name = "value")
    private String value;

    @Column(name = "valueType")
    private String valueType;

}
