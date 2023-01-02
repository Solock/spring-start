package com.adeo.dp4p.sales.sofianetest.repository;
import com.adeo.dp4p.sales.sofianetest.exception.ObjectValueNullException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface IOperatorDatabasePort {

    void saveInDataBase(BigDecimal operator_result, Date operator_date, String operator_operator) throws ObjectValueNullException;
}
