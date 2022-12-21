package com.adeo.dp4p.sales.sofianetest.repository;

import com.adeo.dp4p.sales.sofianetest.exception.ObjectValueNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;

@Repository
public class OperatorH2JPADataBase implements IOperatorDatabase {

    @Autowired
    private IOperatorDatabase ioperatorDatabase;

    @Override
    public void saveInDataBase(BigDecimal operator_result, Date operator_date, String operator_operator) throws ObjectValueNullException {
        ioperatorDatabase.save(operator_result, operator_date, operator_operator);
    }
}
