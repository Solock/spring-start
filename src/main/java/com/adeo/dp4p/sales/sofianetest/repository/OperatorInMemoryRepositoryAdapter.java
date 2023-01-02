package com.adeo.dp4p.sales.sofianetest.repository;

import com.adeo.dp4p.sales.sofianetest.exception.ObjectValueNullException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

@ConditionalOnProperty(name = "config.database.type", havingValue = "memory")
@Repository
public class OperatorInMemoryRepositoryAdapter implements IOperatorDatabasePort {

    private static final HashMap<Long, ResultOperatorEntity> repository = new HashMap<>();
    private static Long count = 0L;

    @Override
    public void saveInDataBase(BigDecimal operator_result, Date operator_date, String operator_operator) throws ObjectValueNullException {
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
