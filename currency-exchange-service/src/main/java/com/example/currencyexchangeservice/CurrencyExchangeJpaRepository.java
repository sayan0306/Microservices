package com.example.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyExchangeJpaRepository extends JpaRepository<CurrencyExchange,Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
}
