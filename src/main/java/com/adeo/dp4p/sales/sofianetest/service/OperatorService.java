package com.adeo.dp4p.sales.sofianetest.service;

import com.adeo.dp4p.sales.sofianetest.repository.IOperatorDatabase;
import com.adeo.dp4p.sales.sofianetest.repository.ResultOperatorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class OperatorService {


    private IOperatorDatabase repository;
    ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();

    @Autowired
    public OperatorService(IOperatorDatabase repository){
        this.repository = repository;
    }

    public BigDecimal subOperator(BigDecimal value1, BigDecimal value2){
        BigDecimal subResult = value1.subtract(value2);
        Date today = new Date();
        String operator = "-";

        try {
            resultOperatorEntity.setResult(subResult);
            resultOperatorEntity.setDate(today);
            resultOperatorEntity.setOperator(operator);
            repository.save(resultOperatorEntity);
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
            resultOperatorEntity.setResult(sumResult);
            resultOperatorEntity.setDate(today);
            resultOperatorEntity.setOperator(operator);
            repository.save(resultOperatorEntity);
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
            resultOperatorEntity.setResult(mutlResult);
            resultOperatorEntity.setDate(today);
            resultOperatorEntity.setOperator(operator);
            repository.save(resultOperatorEntity);
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
            resultOperatorEntity.setResult(divResult);
            resultOperatorEntity.setDate(today);
            resultOperatorEntity.setOperator(operator);
            repository.save(resultOperatorEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return divResult;
    }
}
