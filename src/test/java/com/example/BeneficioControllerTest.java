package com.example;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.TESTEINTEGRADO.TesteintegradoApplication;


@SpringBootTest(classes = TesteintegradoApplication.class)
class BeneficioControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void retornaListaDeBeneficios() throws Exception {
        mockMvc.perform(get("/api/beneficios"))
               .andExpect(status().isOk())
               .andExpect(result -> {
                   String json = result.getResponse().getContentAsString();
                   System.out.println("Resposta JSON: " + json);
               });
    }
}