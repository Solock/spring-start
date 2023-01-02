package com.adeo.dp4p.sales.sofianetest.repository;

import com.adeo.dp4p.sales.sofianetest.exception.ObjectValueNullException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@ConditionalOnProperty(name = "config.database.type", havingValue = "jpa")
@Component
public class OperatorJPADatabaseAdapter implements IOperatorDatabasePort {

    private final JpaRepository jpaRepository;

    public OperatorJPADatabaseAdapter(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void saveInDataBase(BigDecimal operator_result, Date operator_date, String operator_operator) throws ObjectValueNullException {
        jpaRepository.save();
    }
}
