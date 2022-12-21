package com.adeo.dp4p.sales.sofianetest.integration.repository;

import com.adeo.dp4p.sales.sofianetest.repository.OperatorH2JDBCDataBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OperatorH2JDBCDataBaseTest {
    @Autowired
    private OperatorH2JDBCDataBase operatorH2JDBCDataBase;

    @Test
    void test_save_with_right_parameters() throws Exception{
        //given
        BigDecimal result = BigDecimal.valueOf(6);
        Date dateTest = new Date();
        String operator = "+";

        //when
        operatorH2JDBCDataBase.saveInDataBase(result, dateTest, operator);

        //then
        //assertEquals(1, operatorH2JDBCDataBase.findAll().size());
    }




}
