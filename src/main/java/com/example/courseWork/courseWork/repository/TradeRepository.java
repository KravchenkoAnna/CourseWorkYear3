package com.example.courseWork.courseWork.repository;

import com.example.courseWork.courseWork.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    <T> List<T> findAllBy(Class<T> type);
    <T> List<T> findAllByOrderById(Class<T> type);
    <T> Optional<T> findTradeById(long id, Class<T> type);
}
