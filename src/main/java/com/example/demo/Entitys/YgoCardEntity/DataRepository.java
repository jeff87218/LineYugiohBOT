package com.example.demo.Entitys.YgoCardEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Integer> {
    List<Data> findAll();
    List<Data> findById(int integer);

}