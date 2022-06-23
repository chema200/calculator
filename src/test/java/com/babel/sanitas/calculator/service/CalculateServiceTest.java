package com.babel.sanitas.calculator.service;

import com.babel.sanitas.calculator.api.model.Operation;
import com.babel.sanitas.calculator.services.CalculateService;
import com.babel.sanitas.calculator.services.impl.CalculateServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CalculateServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CalculateService calculateService = new CalculateServiceImpl();

    @Test
    public void givenResult_whenPlus_thenReturnValueOK() throws Exception {

        List<BigDecimal> list = new ArrayList<BigDecimal>();
        list.add(new BigDecimal(100));
        list.add(new BigDecimal(200));
        Operation operation = new Operation();
        operation.setOperation("+");
        operation.setParameters(list);

        BigDecimal bigDecimalResult = new BigDecimal(300);

        final BigDecimal response = calculateService.calculate(operation);

        assertEquals(bigDecimalResult, response);
    }

    @Test
    public void givenResult_whenPlus_thenReturnValueNoOK() throws Exception {

        List<BigDecimal> list = new ArrayList<BigDecimal>();
        list.add(new BigDecimal(100));
        list.add(new BigDecimal(200));
        Operation operation = new Operation();
        operation.setOperation("+");
        operation.setParameters(list);
        BigDecimal bigDecimalResult = new BigDecimal(100);

        final BigDecimal response = calculateService.calculate(operation);

        assertNotEquals(bigDecimalResult, response);
    }

    @Test
    public void givenResult_whenSubtract_thenReturnValueOK() throws Exception {

        List<BigDecimal> list = new ArrayList<BigDecimal>();
        list.add(new BigDecimal(100));
        list.add(new BigDecimal(50));
        Operation operation = new Operation();
        operation.setOperation("-");
        operation.setParameters(list);
        BigDecimal bigDecimalResult = new BigDecimal(50);

        final BigDecimal response = calculateService.calculate(operation);

        assertEquals(bigDecimalResult, response);
    }

    @Test
    public void givenResult_whenSubtract_thenReturnValueNoOK() throws Exception {

        List<BigDecimal> list = new ArrayList<BigDecimal>();
        list.add(new BigDecimal(100));
        list.add(new BigDecimal(50));
        Operation operation = new Operation();
        operation.setOperation("-");
        operation.setParameters(list);
        BigDecimal bigDecimalResult = new BigDecimal(0);

        final BigDecimal response = calculateService.calculate(operation);

        assertNotEquals(bigDecimalResult, response);
    }

}
