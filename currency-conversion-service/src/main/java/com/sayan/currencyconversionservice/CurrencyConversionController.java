package com.sayan.currencyconversionservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    private CurrencyExchangeProxy currencyExchangeProxy;

    public CurrencyConversionController(CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    @GetMapping("/currency-conversion/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculatedCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("from",from);
        uriVariable.put("to",to);
        ResponseEntity<CurrencyConversion> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/{from}/to/{to}", CurrencyConversion.class, uriVariable);
        CurrencyConversion conversion = forEntity.getBody();

        assert conversion != null;
        return new CurrencyConversion(
                conversion.getId(),
                conversion.getFrom(),
                conversion.getTo(),
                quantity,
                conversion.getConversionMultiple(),
                quantity.multiply(conversion.getConversionMultiple()),
                conversion.getEnvironment() + " rest template"
        );
    }
    @GetMapping("/currency-conversion-feign/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculatedCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        CurrencyConversion conversion = currencyExchangeProxy.retrieveExchangeValue(from,to);
        assert conversion != null;
        return new CurrencyConversion(
                conversion.getId(),
                conversion.getFrom(),
                conversion.getTo(),
                quantity,
                conversion.getConversionMultiple(),
                quantity.multiply(conversion.getConversionMultiple()),
                conversion.getEnvironment() + " feign"
        );
    }
}
