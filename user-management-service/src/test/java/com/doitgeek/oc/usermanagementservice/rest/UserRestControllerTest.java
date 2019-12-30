package com.doitgeek.oc.usermanagementservice.rest;

import com.doitgeek.oc.usermanagementservice.constant.AppConstant;
import com.doitgeek.oc.usermanagementservice.exception.CustomExceptionHandler;
import com.doitgeek.oc.usermanagementservice.model.UserRegistrationDto;
import com.doitgeek.oc.usermanagementservice.service.UserProfileServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
public class UserRestControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserRestController userRestController;

    @Mock
    private UserProfileServiceImpl userAccountService;

    @Before
    public void setUp() throws Exception {
        //MockitoAnnotations.initMocks(this); // No need to use this if used - @RunWith(SpringRunner.class)
        mockMvc = MockMvcBuilders.standaloneSetup(userRestController).setControllerAdvice(CustomExceptionHandler.class).build();
    }

    @Test
    public void testGetAllUserAccounts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.containsString(AppConstant.SUCCESS)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data", Matchers.hasSize(1)));
    }

    @Test
    public void testGetUserAccountById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/ertd"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").exists());
    }

    @Test
    public void testCreateUserAccount() throws Exception {
        UserRegistrationDto model = new UserRegistrationDto();
        model.setFirstName("Sainath");
        model.setLastName("Parkar");
        model.setEmail("saiparkar4@gmail.com");
        model.setPassword("sainath123");
        model.setMobileNumber("9869631289");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(model);

        mockMvc.perform(MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.containsString(AppConstant.SUCCESS)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists());
    }

    @Test
    public void testUpdateUserAccount() throws Exception {
        UserRegistrationDto model = new UserRegistrationDto();
        model.setFirstName("Sainath");
        model.setLastName("Parkar");
        model.setEmail("saiparkar4@gmail.com");
        model.setPassword("sainath123");
        model.setMobileNumber("9869631289");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(model);

        mockMvc.perform(MockMvcRequestBuilders.put("/users/10").contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}