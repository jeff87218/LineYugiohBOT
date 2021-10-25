package com.example.demo.YgoCardEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TextRepository extends JpaRepository<Text, Integer> {
    List<Text> findById(int integer);

    List<Text> findAll();

    @Query(value = "select * from texts where name like %?1%",nativeQuery = true)
    List<Text> findByNameLike(String name);


}