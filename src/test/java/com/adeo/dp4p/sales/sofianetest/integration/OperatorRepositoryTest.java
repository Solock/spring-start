package com.adeo.dp4p.sales.sofianetest.integration;

import com.adeo.dp4p.sales.sofianetest.repository.OperatorInMemoryRepository;
import com.adeo.dp4p.sales.sofianetest.repository.ResultOperatorEntity;
import org.junit.jupiter.api.Test;
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
    private static long count = 0L;

   @Test
    void test_save_with_right_parameters() throws Exception{
       //given
       ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();
       resultOperatorEntity.setResult(BigDecimal.valueOf(6));
       resultOperatorEntity.setDate(dateTest);
       resultOperatorEntity.setOperator("+");


       //when
       operatorInMemoryRepository.save(resultOperatorEntity.getResult(), resultOperatorEntity.getDate(), resultOperatorEntity.getOperator());

       repository.put(count + 1, resultOperatorEntity);


       //then
       assertEquals(repository.size(), 1);
    }


    @Test
    void test_save_with_wrong_value_result() throws Exception{
        //given
        ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();
        resultOperatorEntity.setResult(null);
        resultOperatorEntity.setDate(dateTest);
        resultOperatorEntity.setOperator("+");

        //when
        operatorInMemoryRepository.save(resultOperatorEntity.getResult(), resultOperatorEntity.getDate(), resultOperatorEntity.getOperator());
        repository.put(0L, resultOperatorEntity);
        //then
        assertEquals("Valeur(s) null(s), inserez des valeurs corrects.", new Exception());
        //Assertions.assertEquals({0=com.adeo.dp4p.sales.sofianetest.repository.ResultOperatorEntity@16cf7fd0}, repository);
    }

    @Test
    void test_save_with_wrong_value_date() throws Exception {
        //given
        ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();
        resultOperatorEntity.setResult(BigDecimal.valueOf(6));
        resultOperatorEntity.setDate(dateTest);
        resultOperatorEntity.setOperator("+");

        //when
        operatorInMemoryRepository.save(resultOperatorEntity.getResult(), resultOperatorEntity.getDate(), resultOperatorEntity.getOperator());
        repository.put(0L, resultOperatorEntity);
        //then
    }

    @Test
    void test_save_with_wrong_value_operator() throws Exception{
        //given
        ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();
        resultOperatorEntity.setResult(BigDecimal.valueOf(6));
        resultOperatorEntity.setDate(dateTest);
        resultOperatorEntity.setOperator("+");

        //when
        operatorInMemoryRepository.save(resultOperatorEntity.getResult(), resultOperatorEntity.getDate(), resultOperatorEntity.getOperator());
        repository.put(0L, resultOperatorEntity);

        //then
        //Assertions.assertEquals(, repository);
    }

}
