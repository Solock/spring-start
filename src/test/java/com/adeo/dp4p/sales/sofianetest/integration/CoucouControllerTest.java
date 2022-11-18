package com.adeo.dp4p.sales.sofianetest.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CoucouControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_work() throws Exception{
        //when
        MvcResult result = this.mockMvc.perform(get("/message")).andReturn();

        //then
        assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
        assertEquals("coucou",result.getResponse().getContentAsString());

    }

    @Test
    public void test_with_bad_path() throws Exception{
        //when
        MvcResult badResult = this.mockMvc.perform(get("/messssage")).andReturn();

        //then
        assertEquals(HttpStatus.NOT_FOUND.value(), badResult.getResponse().getStatus());
    }


}
