package com.sayan.currencyconversionservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionJpaRepository extends JpaRepository<CurrencyConversion, Long> {
}
