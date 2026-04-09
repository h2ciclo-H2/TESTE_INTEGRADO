package com.example.TESTEINTEGRADO.test;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@AutoConfigureMockMvc
class BeneficioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //@MockBean
   // private BeneficioEjbService beneficioService;


    @Test
    void deveRetornarListaDeBeneficios() throws Exception {
        mockMvc.perform(get("/api/beneficios"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}