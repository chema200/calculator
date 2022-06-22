package com.babel.sanitas.calculator.services;

import com.babel.sanitas.calculator.api.controllers.dto.Operation;

import java.math.BigDecimal;

public interface CalculateService {

    public BigDecimal calculate(Operation operation);
}
