package com.adeo.dp4p.sales.sofianetest.controller;

import com.adeo.dp4p.sales.sofianetest.service.CoucouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoucouController {
    @Autowired
    private CoucouService coucouService;

    @GetMapping("/message")
    public String message(){
        return coucouService.message();
    }
}
