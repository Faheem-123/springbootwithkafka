package com.springboot.kafka.repository;

import com.springboot.kafka.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaData,Integer> {
}
