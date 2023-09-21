package com.example.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
//    @Retry(name = "sample-api",fallbackMethod = "errorMessage") // retry to call the api 3 times by default if not manually set other values , if failed all calls, returns methodFallBack method
//    @CircuitBreaker(name = "sample-api",fallbackMethod = "errorMessage") // calls the api for certain times and if all calls are failed, returns the fallbackMethod .
//    @RateLimiter(name = "default") //limits the api calls upto certain times
    @Bulkhead(name = "sample-api") // max concurrent calls
    @GetMapping("/sample-api")
    public String sampleApi(){
        logger.info("Sample Api Requested");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8765/currency-exchange/AED/to/INR", String.class);
//        return forEntity.getBody();
        return "Sample API";
    }
    public String errorMessage(Exception exception){
        return "Server Down";
    }
}
