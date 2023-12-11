package com.example.courseWork.courseWork.repository;

import com.example.courseWork.courseWork.entity.Detal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DetalRepository extends JpaRepository<Detal, Long> {
    Optional<Detal> findByNameIgnoreCase(String name);

    <T> List<T> findAllBy(Class<T> type);
}
