package com.adeo.dp4p.sales.sofianetest.repository;

import com.adeo.dp4p.sales.sofianetest.exception.ObjectValueNullException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Date;

public interface IOperatorDatabase extends JpaRepository<ResultOperatorEntity, Long> {

    void saveInDataBase(BigDecimal operator_result, Date operator_date, String operator_operator)
            throws ObjectValueNullException;

}
