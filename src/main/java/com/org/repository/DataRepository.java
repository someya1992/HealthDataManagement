package com.org.repository;

import com.org.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Long> {

    List<Data> findByUserId(String userId);

}
