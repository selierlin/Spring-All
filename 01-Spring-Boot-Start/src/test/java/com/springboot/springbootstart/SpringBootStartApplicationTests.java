package com.springboot.springbootstart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootStartApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        String content = mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andReturn().getResponse().getContentAsString();
        System.out.println(content);
    }

}
