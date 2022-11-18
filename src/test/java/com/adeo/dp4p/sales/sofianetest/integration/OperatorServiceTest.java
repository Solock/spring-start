package com.adeo.dp4p.sales.sofianetest.integration;


import com.adeo.dp4p.sales.sofianetest.service.OperatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OperatorServiceTest {

    @Autowired
    private OperatorService operatorService;

    @ParameterizedTest
    @CsvSource({"3, 2", "1, 4", "5, 0"})
    public void GetSum(BigDecimal value1, BigDecimal value2){

        BigDecimal result = operatorService.sumOperator(value1, value2);

        assertEquals(BigDecimal.valueOf(5), result);
    }

    @ParameterizedTest
    @CsvSource({"15, 10", "40, 35", "50, 45"})
    public void GetSub(BigDecimal value1, BigDecimal value2){

        BigDecimal result = operatorService.subOperator(value1, value2);

        assertEquals(BigDecimal.valueOf(5), result);
    }

    @ParameterizedTest
    @CsvSource({"1, 6", "2, 3"})
    public void GetMult(BigDecimal value1, BigDecimal value2){

        BigDecimal result = operatorService.multOperator(value1, value2);

        assertEquals(BigDecimal.valueOf(6), result);
    }

    @ParameterizedTest
    @CsvSource({"6, 3", "4, 2"})
    public void GetDiv(BigDecimal value1, BigDecimal value2){

        BigDecimal result = operatorService.divOperator(value1, value2);

        assertEquals(BigDecimal.valueOf(2), result);
    }

}
