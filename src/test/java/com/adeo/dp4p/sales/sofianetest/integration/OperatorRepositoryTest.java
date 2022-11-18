package com.adeo.dp4p.sales.sofianetest.integration;

import com.adeo.dp4p.sales.sofianetest.repository.OperatorInMemoryRepository;
import com.adeo.dp4p.sales.sofianetest.repository.ResultOperatorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OperatorRepositoryTest {

    @Autowired
    OperatorInMemoryRepository operatorInMemoryRepository;

    Date dateTest = new Date();

    private static final HashMap<Long, ResultOperatorEntity> repository = new HashMap<>();


   @Test
    void test_save_with_right_parameters() throws Exception{
       ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();
       resultOperatorEntity.setResult(BigDecimal.valueOf(6));
       resultOperatorEntity.setDate(dateTest);
       resultOperatorEntity.setOperator("+");

       operatorInMemoryRepository.save(resultOperatorEntity.getResult(), resultOperatorEntity.getDate(), resultOperatorEntity.getOperator());

    }
}
