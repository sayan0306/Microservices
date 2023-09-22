package com.example.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CurrencyExchangeController {
    private final Environment environment;
    private final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    private final CurrencyExchangeService service;
    public CurrencyExchangeController(Environment environment, CurrencyExchangeService service) {
        this.environment = environment;
        this.service = service;
    }


    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        logger.info("retrieveExchangeValue called with parameters from {} to {}",from,to);
        CurrencyExchange fromAndTo = service.getFromAndTo(from, to);
        if (fromAndTo == null) throw new RuntimeException("Conversion table from "+ from + " to "+to + " is not available");
        fromAndTo.setEnvironment(environment.getProperty("local.server.port"));
        return fromAndTo;
    }
}
