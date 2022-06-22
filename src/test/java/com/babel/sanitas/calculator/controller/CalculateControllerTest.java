package com.babel.sanitas.calculator.controller;

import com.babel.sanitas.calculator.api.controllers.dto.Operation;
import com.babel.sanitas.calculator.services.CalculateService;
import com.babel.sanitas.calculator.services.impl.CalculateServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CalculateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CalculateService calculateService = new CalculateServiceImpl();

    @Test
    public void givenResult_whenPlus_thenReturnValueOK() throws Exception {

        List<BigDecimal> list = new ArrayList<BigDecimal>();
        list.add(new BigDecimal(100));
        list.add(new BigDecimal(200));
        Operation operation = new Operation("+", list);

        BigDecimal bigDecimalResult = new BigDecimal(300);

        final ObjectMapper mapper = new ObjectMapper();
        final String opeDtoJson = mapper.writeValueAsString(operation);

        var operate = mockMvc.perform(post("/calculate")
                        .content(opeDtoJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var operateResult = mapper.readValue(operate.getResponse().getContentAsString(), BigDecimal.class);
        assert operateResult.equals(bigDecimalResult);
    }

    @Test
    public void givenResult_whenPlus_thenReturnValueNoOK() throws Exception {

        List<BigDecimal> list = new ArrayList<BigDecimal>();
        list.add(new BigDecimal(100));
        list.add(new BigDecimal(200));
        Operation operation = new Operation("+", list);

        BigDecimal bigDecimalResult = new BigDecimal(100);

        final ObjectMapper mapper = new ObjectMapper();
        final String opeDtoJson = mapper.writeValueAsString(operation);

        var operate = mockMvc.perform(post("/calculate")
                        .content(opeDtoJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var operateResult = mapper.readValue(operate.getResponse().getContentAsString(), BigDecimal.class);
        assert !operateResult.equals(bigDecimalResult);
    }

    @Test
    public void givenResult_whenSubtract_thenReturnValueOK() throws Exception {

        List<BigDecimal> list = new ArrayList<BigDecimal>();
        list.add(new BigDecimal(100));
        list.add(new BigDecimal(50));
        Operation operation = new Operation("-", list);

        BigDecimal bigDecimalResult = new BigDecimal(50);

        final ObjectMapper mapper = new ObjectMapper();
        final String opeDtoJson = mapper.writeValueAsString(operation);

        var operate = mockMvc.perform(post("/calculate")
                        .content(opeDtoJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var operateResult = mapper.readValue(operate.getResponse().getContentAsString(), BigDecimal.class);
        assert operateResult.equals(bigDecimalResult);
    }

    @Test
    public void givenResult_whenSubtract_thenReturnValueNoOK() throws Exception {

        List<BigDecimal> list = new ArrayList<BigDecimal>();
        list.add(new BigDecimal(100));
        list.add(new BigDecimal(50));
        Operation operation = new Operation("-", list);

        BigDecimal bigDecimalResult = new BigDecimal(0);

        final ObjectMapper mapper = new ObjectMapper();
        final String opeDtoJson = mapper.writeValueAsString(operation);

        var operate = mockMvc.perform(post("/calculate")
                        .content(opeDtoJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var operateResult = mapper.readValue(operate.getResponse().getContentAsString(), BigDecimal.class);
        assert !operateResult.equals(bigDecimalResult);
    }
}
