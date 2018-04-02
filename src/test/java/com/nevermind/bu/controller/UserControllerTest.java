package com.nevermind.bu.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserControllerTest {
    @Test
    public void shouldShowLoginPage() throws Exception {
        UserController controller = new UserController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/login")).andExpect(view().name("loginPage"));
    }

    @Test
    public void shouldShowRegisterPage() throws Exception {
        UserController controller = new UserController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/register")).andExpect(view().name("registerUser"));
    }
}
