package com.adeo.dp4p.sales.sofianetest.integration.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_without_parameters() throws Exception{
        //when
        MvcResult resultOut = this.mockMvc.perform(get("/sum")).andReturn();

        //then
        assertEquals(HttpStatus.BAD_REQUEST.value(), resultOut.getResponse().getStatus());
    }

    @Test
    public void test_with_parameters() throws Exception{
        //when
        MvcResult result = this.mockMvc.perform(get("/sum?value1=2&value2=3")).andReturn();

        //then
        assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
        assertEquals("5",result.getResponse().getContentAsString());
    }

}
