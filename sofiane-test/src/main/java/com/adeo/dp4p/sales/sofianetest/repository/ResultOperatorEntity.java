package com.adeo.dp4p.sales.sofianetest.repository;

import java.math.BigDecimal;
import java.util.Date;

public class ResultOperatorEntity {

    private BigDecimal result;
    private Date date;
    private String operator;

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
