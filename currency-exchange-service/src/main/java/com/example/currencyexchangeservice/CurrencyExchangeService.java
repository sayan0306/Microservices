package com.example.currencyexchangeservice;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CurrencyExchangeService {
    private final CurrencyExchangeJpaRepository currencyExchangeJpaRepository;

    public CurrencyExchangeService(CurrencyExchangeJpaRepository currencyExchangeJpaRepository) {
        this.currencyExchangeJpaRepository = currencyExchangeJpaRepository;
    }
    public List<CurrencyExchange> getAllData(){
        return currencyExchangeJpaRepository.findAll();
    }
    public CurrencyExchange getFromAndTo(String from, String to){
       return currencyExchangeJpaRepository.findByFromAndTo(from,to);
    }
    public CurrencyExchange getDataById(Long id){
        return currencyExchangeJpaRepository.findById(id).orElse(null);
    }
    public void saveData(CurrencyExchange exchange){
        currencyExchangeJpaRepository.save(exchange);
    }
    public void deleteData(CurrencyExchange exchange){
        currencyExchangeJpaRepository.delete(exchange);
    }

}
