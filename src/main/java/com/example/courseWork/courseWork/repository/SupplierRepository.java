package com.example.courseWork.courseWork.repository;


import com.example.courseWork.courseWork.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findByNameIgnoreCase(String name);

    <T> List<T> findAllBy(Class<T> type);
}
