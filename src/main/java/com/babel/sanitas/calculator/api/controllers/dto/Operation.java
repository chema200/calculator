package com.babel.sanitas.calculator.api.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class Operation {
    private String operation;

    private List<BigDecimal> parameters;
}
