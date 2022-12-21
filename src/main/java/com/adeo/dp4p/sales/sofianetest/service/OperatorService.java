package com.adeo.dp4p.sales.sofianetest.service;

import com.adeo.dp4p.sales.sofianetest.repository.IOperatorDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class OperatorService {

    private final IOperatorDatabase operatorDatabase;

    public BigDecimal subOperator(BigDecimal value1, BigDecimal value2){
        BigDecimal subResult = value1.subtract(value2);
        Date today = new Date();
        String operator = "-";

        try {
            operatorDatabase.saveInDataBase(subResult, today, operator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return subResult ;

    }

    public BigDecimal sumOperator(BigDecimal value1, BigDecimal value2){
        BigDecimal sumResult = value1.add(value2);
        Date today = new Date();
        String operator = "+";

        try {
            operatorDatabase.saveInDataBase(sumResult, today, operator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return sumResult;
    }

    public BigDecimal multOperator(BigDecimal value1, BigDecimal value2){
        BigDecimal mutlResult = value1.multiply(value2);
        Date today = new Date();
        String operator = "*";

        try {
            operatorDatabase.saveInDataBase(mutlResult, today, operator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return mutlResult;

    }

    public BigDecimal divOperator(BigDecimal value1, BigDecimal value2){
        BigDecimal divResult = value1.divide(value2);
        Date today = new Date();
        String operator = "/";

        try {
            operatorDatabase.saveInDataBase(divResult, today, operator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return divResult;
    }
}
