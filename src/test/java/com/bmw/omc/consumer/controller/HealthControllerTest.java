package com.consumer.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HealthController.class)
@ActiveProfiles(profiles = "local")
public class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/health")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void testHealthEndpointResponse() throws Exception {
        MvcResult result = mockMvc.perform(get("/health")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Up"));
    }

}