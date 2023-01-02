package com.adeo.dp4p.sales.sofianetest.repository;

import com.adeo.dp4p.sales.sofianetest.exception.ObjectValueNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ConditionalOnProperty(name = "config.database.type", havingValue = "h2")
@Repository
public class OperatorH2JDBCDataBaseAdapter implements IOperatorDatabasePort {

    private final NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public OperatorH2JDBCDataBaseAdapter(final NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public static String CREATE_VALUE_OPERATOR =
            "INSERT INTO resutl_operator_entity (operator_id, operator_date, operator_operator, operator_result) "
                    + "VALUES (:operator_id, :operator_date, :operator_operator, :operator_result)";

    @Override
    public void saveInDataBase(BigDecimal operator_result, Date operator_date, String operator_operator) throws ObjectValueNullException {
        if (operator_result == null || operator_date == null || operator_operator == null)  {
            throw new ObjectValueNullException("Veuillez saisir des valeurs non nulles");
        }
        else {
            final Map<String, Object> map = new HashMap<>();
            map.put("operator_id", getNextId());
            map.put("operator_date", operator_date);
            map.put("operator_result", operator_result);
            map.put("operator_operator", operator_operator);

            jdbcOperations.update(CREATE_VALUE_OPERATOR, map);

        }

    }

    private long getNextId() {
        //TODO
        // SELECT MAX + 1
        return 0;
    }

}