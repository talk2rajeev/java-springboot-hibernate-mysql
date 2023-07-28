package com.restapi.restapiexample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.restapi.restapiexample.model.User;
import com.restapi.restapiexample.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    User user1;
    User user2;
    List<User> userList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        user1 = new User("1", "Raj", "E-city", "8t8777867698");
        user2 = new User("2", "Dev", "JP nagar", "79876587899");
        userList.add(user1);
        userList.add(user2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUserDetail() throws Exception{
        when(userService.getUser("1")).thenReturn(user1);
        this.mockMvc.perform(get("/user/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getAllUsersDetail() throws Exception {
        when(userService.getUsers()).thenReturn(userList);
        this.mockMvc.perform(get("/user")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void createUserDetail() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper  .configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(user1);

        when(userService.createUser(user1)).thenReturn("Success");
        this.mockMvc.perform(
                post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateUserDetail() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper  .configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(user1);

        when(userService.updateUser(user1)).thenReturn("Success");
        this.mockMvc.perform(
                put("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deleteUserDetail() throws Exception{
        when(userService.deleteUser("1")).thenReturn("Success");
        this.mockMvc.perform(delete("/user/1")).andDo(print()).andExpect(status().isOk());
    }
}