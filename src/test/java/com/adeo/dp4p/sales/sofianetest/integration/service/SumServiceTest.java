package com.adeo.dp4p.sales.sofianetest.integration.service;

import com.adeo.dp4p.sales.sofianetest.service.SumService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SumServiceTest {

    @Autowired
    private SumService sumService;


    @ParameterizedTest
    @CsvSource({"3, 2", "1, 4", "5, 0"})
    public void GetSum(Integer value1, Integer value2){

        Integer result = sumService.sum(value1, value2);

        assertEquals(5, result);
    }
}
