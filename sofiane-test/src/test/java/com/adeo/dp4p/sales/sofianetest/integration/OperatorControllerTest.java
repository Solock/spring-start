package com.adeo.dp4p.sales.sofianetest.integration;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class OperatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_without_parameters() throws Exception{
        //when
        MvcResult resultOut = this.mockMvc.perform(get("/operator")).andReturn();

        //then
        assertEquals(HttpStatus.NOT_FOUND.value(), resultOut.getResponse().getStatus());
    }

    @Test
    public void test_with_parameters_for_sum() throws Exception{
        //when
        MvcResult result = this.mockMvc.perform(get("/operator/sum?value1=2&value2=3")).andReturn();

        //then
        assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
        assertEquals("5",result.getResponse().getContentAsString());
    }

    @Test
    public void test_with_parameters_for_sub() throws Exception{
        //when
        MvcResult result = this.mockMvc.perform(get("/operator/sub?value1=2&value2=3")).andReturn();

        //then
        assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
        assertEquals("-1",result.getResponse().getContentAsString());
    }

    @Test
    public void test_with_parameters_for_mult() throws Exception{
        //when
        MvcResult result = this.mockMvc.perform(get("/operator/mult?value1=2&value2=3")).andReturn();

        //then
        assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
        assertEquals("6",result.getResponse().getContentAsString());
    }

    @Test
    public void test_with_parameters_for_div() throws Exception{
        //when
        MvcResult result = this.mockMvc.perform(get("/operator/div?value1=6&value2=3")).andReturn();

        //then
        assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
        assertEquals("2",result.getResponse().getContentAsString());
    }

    @Test
    public void test_with_parameters_for_div_with_zero() throws Exception{
        //when
        MvcResult result = this.mockMvc.perform(get("/operator/div?value1=0&value2=6")).andReturn();

        //then
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
    }

}
