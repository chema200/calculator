package com.babel.sanitas.calculator.services.impl;

import com.babel.sanitas.calculator.api.controllers.dto.Operation;
import com.babel.sanitas.calculator.services.CalculateService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Validated
public class CalculateServiceImpl implements CalculateService {


    private static final String PLUS = "+";
    private static final String SUBTRACT = "-";


    @Override
    public BigDecimal calculate(Operation operation) {
        BigDecimal result = BigDecimal.ZERO;
        switch (operation.getOperation()) {
            case PLUS: {
                result = operation.getParameters().stream().reduce(BigDecimal.ZERO, BigDecimal::add);

            }
            break;
            case SUBTRACT: {
                Optional<BigDecimal> resultOptional = operation.getParameters().stream().reduce((m, n) -> m.subtract(n));
                result = resultOptional.get();
            }
            break;
        }
        return result;
    }
}
