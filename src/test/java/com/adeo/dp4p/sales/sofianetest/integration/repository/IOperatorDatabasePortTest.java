package com.adeo.dp4p.sales.sofianetest.integration.repository;

import com.adeo.dp4p.sales.sofianetest.repository.IOperatorDatabasePort;
import com.adeo.dp4p.sales.sofianetest.repository.ResultOperatorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;


@DataJpaTest
public class IOperatorDatabasePortTest {
    @Autowired
    IOperatorDatabasePort repository;
    ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();

    @Test
    void save_method_work() {
        resultOperatorEntity.setOperator("-");
        resultOperatorEntity.setDate(new Date());
        resultOperatorEntity.setResult(BigDecimal.valueOf(6));

        repository.save(resultOperatorEntity);

        ResultOperatorEntity foundId = repository.findById(resultOperatorEntity.getOperator_id()).get();

        assertEquals(resultOperatorEntity.getOperator_id(), foundId.getOperator_id());
    }

}
