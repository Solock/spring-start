package com.adeo.dp4p.sales.sofianetest.repository;

import com.adeo.dp4p.sales.sofianetest.exception.ObjectValueNullException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

@Repository
public class OperatorInMemoryRepository {

    private static final HashMap<Long, ResultOperatorEntity> repository = new HashMap<>();
    private static Long count = 0L;

    public static void save(BigDecimal result, Date date, String operator) throws Exception {
        if (result == null || date == null || operator == null)  {
            throw new ObjectValueNullException("Veuillez saisir des valeurs non nulles");
        }
        else {
            ResultOperatorEntity resultOperatorEntity = new ResultOperatorEntity();
            resultOperatorEntity.setResult(result);
            resultOperatorEntity.setDate(date);
            resultOperatorEntity.setOperator(operator);

            repository.put(count+1, resultOperatorEntity);
        }



    }
}
