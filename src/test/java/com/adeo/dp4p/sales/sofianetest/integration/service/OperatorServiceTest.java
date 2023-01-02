package com.adeo.dp4p.sales.sofianetest.integration.service;

import com.adeo.dp4p.sales.sofianetest.service.OperatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class OperatorServiceTest {

    @Autowired
    private OperatorService operatorService;

    @ParameterizedTest
    @CsvSource({"3, 2", "1, 4", "5, 0"})
    public void get_sum(BigDecimal value1, BigDecimal value2){

        BigDecimal result = operatorService.sumOperator(value1, value2);

        assertEquals(BigDecimal.valueOf(5), result);
    }

    @ParameterizedTest
    @CsvSource({"15, 10", "40, 35", "50, 45"})
    public void get_sub(BigDecimal value1, BigDecimal value2){

        BigDecimal result = operatorService.subOperator(value1, value2);

        assertEquals(BigDecimal.valueOf(5), result);
    }

    @ParameterizedTest
    @CsvSource({"1, 6", "2, 3"})
    public void get_mult(BigDecimal value1, BigDecimal value2){

        BigDecimal result = operatorService.multOperator(value1, value2);

        assertEquals(BigDecimal.valueOf(6), result);
    }

    @ParameterizedTest
    @CsvSource({"6, 3", "4, 2"})
    public void get_div(BigDecimal value1, BigDecimal value2){

        BigDecimal result = operatorService.divOperator(value1, value2);

        assertEquals(BigDecimal.valueOf(2), result);
    }

    @ParameterizedTest(name = "Number 1 : {0} and Number 2 : null")
    @CsvSource({"3", "4", "5"})
    public void get_exception_when_save_called(BigDecimal value1) {

        // when
        RuntimeException ex = assertThrows(RuntimeException.class, () -> operatorService.subOperator(value1, null));

        //then
        assertTrue(( ex instanceof RuntimeException));
    }
}
