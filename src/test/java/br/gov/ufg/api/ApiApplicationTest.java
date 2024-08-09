package br.gov.ufg.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ApiApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        assertThat(applicationContext).isNotNull();
    }

    @Test
    void testProdutoControllerLoaded() {
        // Verifica se o ProdutoController está presente no contexto da aplicação
        boolean controllerPresent = applicationContext.containsBean("produtoController");
        assertThat(controllerPresent).isTrue();
    }
}
