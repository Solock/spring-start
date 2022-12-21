package com.adeo.dp4p.sales.sofianetest.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ResultOperatorEntity {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private Long operator_id;

    private BigDecimal operator_result;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date operator_date;

    private String operator_operator;

    public Long getOperator_id() {
        return operator_id;
    }

    public void setId(Long id) {
        this.operator_id = operator_id;
    }

    public BigDecimal getResult() {
        return operator_result;
    }

    public void setResult(BigDecimal result) {
        this.operator_result = operator_result;
    }

    public Date getDate() {
        return operator_date;
    }

    public void setDate(Date date) {
        this.operator_date = operator_date;
    }

    public String getOperator() {
        return operator_operator;
    }

    public void setOperator(String operator) {
        this.operator_operator = operator_operator;
    }
}
