package com.project.ecommerce.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ecommerce.model.User;
import com.project.ecommerce.service.UserService;

import io.swagger.v3.oas.models.media.MediaType;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	private User user = new User();


	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		user.setDni(1);
		user.setFirstName("jose");
		user.setLastName("mendoza");
		user.setAge(23);
		user.setBirthDate(null);
		user.setCreationDate(null);
		user.setDirection("cabildo 111");
		user.setMail("josem@gmail.com");
		user.setTelf(1126456987);
		
	}

	@Test
    void findUserSuccess() throws Exception {
        when(userService.existsUser(1)).thenReturn(true);
        when(userService.findU(1)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/user/finduser/{dni}",1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dni").value(user.getDni()))
                .andExpect(jsonPath("$.firstName").value(user.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(user.getLastName()))
                .andExpect(jsonPath("$.mail").value(user.getMail()));
    }

	@Test
    void notFoundUser() throws Exception {
        when(userService.existsUser(1)).thenReturn(false);

        mockMvc.perform(get("/user/finduser/1"))
                .andExpect(status().isBadRequest());
    }

	@Test
    void findUserFailure() throws Exception {
        when(userService.existsUser(1)).thenReturn(true);
        when(userService.findU(1)).thenThrow(new RuntimeException());

        mockMvc.perform(get("/user/finduser/1"))
                .andExpect(status().isInternalServerError());
       }



}
