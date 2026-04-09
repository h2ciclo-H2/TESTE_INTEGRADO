package com.example.TESTEINTEGRADO.test;

@SpringBootTest
@Transactional // Revolve o banco ao estado original após cada teste
class BeneficioServiceTest {

    @Autowired
    private BeneficioEjbService service;

    @Test
    void deveSalvarNovoBeneficio() {
        Beneficio b = new Beneficio();
        b.setNome("Beneficio A");
        b.setValor(new BigDecimal("500.00"));
        b.setAtivo(true);

        Beneficio salvo = service.salvar(b);

        assertNotNull(salvo.getId());
        assertEquals("Beneficio A", salvo.getNome());
    }

    @Test
    void deveListarBeneficios() {
        List<Beneficio> lista = service.listarTodosBeneficios();
        assertNotNull(lista);
    }
}
