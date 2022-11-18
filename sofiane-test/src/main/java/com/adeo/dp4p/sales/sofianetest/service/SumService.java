package com.adeo.dp4p.sales.sofianetest.service;

import org.springframework.stereotype.Service;
@Service
public class SumService {
    public Integer sum(Integer value1, Integer value2 ){
        return value1+value2;
    }
}
