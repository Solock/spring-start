package com.adeo.dp4p.sales.sofianetest.integration;

import com.adeo.dp4p.sales.sofianetest.exception.ObjectValueNullException;
import com.adeo.dp4p.sales.sofianetest.repository.OperatorInMemoryRepository;
import com.adeo.dp4p.sales.sofianetest.repository.ResultOperatorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OperatorRepositoryTest {
    @Autowired
    OperatorInMemoryRepository operatorInMemoryRepository;

    private static final HashMap<Long, ResultOperatorEntity> repository = new HashMap<>();
    private static long count = 0L;

   @Test
    void test_save_with_right_parameters() throws Exception{
       //given
       BigDecimal result = BigDecimal.valueOf(6);
       Date dateTest = new Date();
       String operator = "+";

       ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();
       resultOperatorEntity.setResult(result);
       resultOperatorEntity.setDate(dateTest);
       resultOperatorEntity.setOperator(operator);

       //when
       operatorInMemoryRepository.save(resultOperatorEntity.getResult(), resultOperatorEntity.getDate(), resultOperatorEntity.getOperator());
       repository.put(count + 1, resultOperatorEntity);

       //then
       assertEquals(repository.size(), 1);
    }

    @Test
    void test_save_with_wrong_value_result() throws Exception {

           //given
           BigDecimal result = null;
           Date dateTest = new Date();
           String operator = "-";

           ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();
           resultOperatorEntity.setResult(result);
           resultOperatorEntity.setDate(dateTest);
           resultOperatorEntity.setOperator(operator);

            //when&then
            assertThrows(ObjectValueNullException.class, () ->
                    operatorInMemoryRepository.save(result, dateTest, operator));
    }

    @Test
    void test_save_with_wrong_value_date() throws Exception {
        //given
        BigDecimal result = BigDecimal.valueOf(8);
        Date dateTest = null;
        String operator = "*";

        ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();
        resultOperatorEntity.setResult(result);
        resultOperatorEntity.setDate(dateTest);
        resultOperatorEntity.setOperator(operator);

        //then
        assertThrows(ObjectValueNullException.class, () ->
                operatorInMemoryRepository.save(result, dateTest, operator));
    }

    @Test
    void test_save_with_wrong_value_operator() throws Exception{
        //given
        BigDecimal result = BigDecimal.valueOf(7);
        Date dateTest = new Date();
        String operator = null;

        ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();
        resultOperatorEntity.setResult(result);
        resultOperatorEntity.setDate(dateTest);
        resultOperatorEntity.setOperator(operator);

        //then
        assertThrows(ObjectValueNullException.class, () ->
                operatorInMemoryRepository.save(result, dateTest, operator));
    }

}
