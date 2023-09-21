package com.example.currencyexchangeservice;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrencyExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "currency_from", columnDefinition = "VARCHAR(255) NOT NULL")
    private String from;
    @Column(name = "currency_to",columnDefinition = "VARCHAR(255) NOT NULL")
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
