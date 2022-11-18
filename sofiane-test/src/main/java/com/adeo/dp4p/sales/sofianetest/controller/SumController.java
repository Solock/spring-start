package com.adeo.dp4p.sales.sofianetest.controller;

import com.adeo.dp4p.sales.sofianetest.service.CoucouService;
import com.adeo.dp4p.sales.sofianetest.service.SumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    @Autowired
    private SumService sumService;

    @GetMapping("/sum")
    public Integer sum(@RequestParam("value1") Integer value1, @RequestParam("value2") Integer value2){

        return sumService.sum(value1,value2);
    }
}
