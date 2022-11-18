package com.adeo.dp4p.sales.sofianetest.integration;

import com.adeo.dp4p.sales.sofianetest.service.CoucouService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoucouServiceTest {

    @Autowired
    private CoucouService coucouService;

    @Test
    public void GetCoucou(){

        String expected = "coucou";

        String result = coucouService.message();

        assertEquals(expected, result);
    }
}
