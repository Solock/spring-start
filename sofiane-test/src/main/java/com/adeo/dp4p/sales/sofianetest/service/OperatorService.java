package com.adeo.dp4p.sales.sofianetest.service;

import com.adeo.dp4p.sales.sofianetest.repository.OperatorInMemoryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;


@Service
public class OperatorService {

    public BigDecimal subOperator(BigDecimal value1, BigDecimal value2){
        Date aujourdhui = new Date();
        BigDecimal subResult = value1.subtract(value2);
        return subResult ;
        //OperatorInMemoryRepository.save(subResult,aujourdhui,"-");
    }

    public BigDecimal sumOperator(BigDecimal value1, BigDecimal value2){
        BigDecimal sumResult = value1.add(value2);

        return sumResult;
        //OperatorInMemoryRepository.save(sumResult, , "+" );
    }

    public BigDecimal multOperator(BigDecimal value1, BigDecimal value2){
        BigDecimal mutlResult = value1.multiply(value2);
        return mutlResult;
        //OperatorInMemoryRepository.save(mutlResult, , "-" );
    }

    public BigDecimal divOperator(BigDecimal value1, BigDecimal value2){
        BigDecimal divResult = value1.divide(value2);
        return divResult;
        //OperatorInMemoryRepository.save(divResult, , "-" );
    }
}
