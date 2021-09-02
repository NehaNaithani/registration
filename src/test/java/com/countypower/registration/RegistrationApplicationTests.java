package com.countypower.registration;

import com.countypower.registration.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {
        String value = "[{\"id\":1,\"surname\":\"Scott\",\"firstName\":\"Bob\",\"emailAddress\":\"bob@gmail.com\"},{\"id\":2,\"surname\":\"Scott\",\"firstName\":\"Todd\",\"emailAddress\":\"todd@gmail.com\"},{\"id\":3,\"surname\":\"Hopkins\",\"firstName\":\"Mathew\",\"emailAddress\":\"mat@gmail.com\"}]";
        this.mockMvc.perform(get("/api/v1/user")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(value));
    }

}
