package com.example.demo.Entitys.YgoCardEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeprefixRepository extends JpaRepository<Typeprefix, Integer> {

    @Query(value = "select * from typeprefix where type = ?1",nativeQuery = true)
    List<Typeprefix> findBytype(int integer);

    List<Typeprefix> findAll();

}