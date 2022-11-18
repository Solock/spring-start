package com.adeo.dp4p.sales.sofianetest.controller;

import com.adeo.dp4p.sales.sofianetest.service.OperatorService;
import com.adeo.dp4p.sales.sofianetest.service.SumService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @GetMapping("/operator/sub")
    public BigDecimal sub(@RequestParam("value1") String value1, @RequestParam("value2") String value2){
        BigDecimal valueChange1 = new BigDecimal(value1);
        BigDecimal valueChange2 = new BigDecimal(value2);

        return operatorService.subOperator(valueChange1,valueChange2);

    }

    @GetMapping("/operator/sum")
    public BigDecimal sum(@RequestParam("value1") String value1, @RequestParam("value2") String value2){
        BigDecimal valueChange1 = new BigDecimal(value1);
        BigDecimal valueChange2 = new BigDecimal(value2);

        return operatorService.sumOperator(valueChange1,valueChange2);
    }

    @GetMapping("/operator/mult")
    public BigDecimal mult(@RequestParam("value1") String  value1, @RequestParam("value2") String value2){
        BigDecimal valueChange1 = new BigDecimal(value1);
        BigDecimal valueChange2 = new BigDecimal(value2);

        return operatorService.multOperator(valueChange1,valueChange2);
    }

    @GetMapping("/operator/div")
    ResponseEntity<Object> div(@RequestParam("value1") String  value1, @RequestParam("value2") String value2){
        BigDecimal valueChange1 = new BigDecimal(value1);
        BigDecimal valueChange2 = new BigDecimal(value2);

        if (BigDecimal.ZERO.equals(valueChange1) || BigDecimal.ZERO.equals(valueChange2))  {
            return ResponseEntity.badRequest()
                    .body("Insérez une valeur differente de 0");
        }
        else {
            return ResponseEntity.ok()
                    .body(operatorService.divOperator(valueChange1, valueChange2));
        }
    }

}
