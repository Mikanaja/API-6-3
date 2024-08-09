package br.gov.ufg.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.gov.ufg.entity.Cliente;
import br.gov.ufg.entity.ClientePessoaFisica;
import br.gov.ufg.entity.ClientePessoaJuridica;

public class ClienteTest {

    private Cliente clienteFisico;
    private Cliente clienteJuridico;

    @BeforeEach
    public void setUp() {
        clienteFisico = new ClientePessoaFisica();
        clienteFisico.setIdCliente(1);
        clienteFisico.setNome("João Silva");
        clienteFisico.setEmail("joao.silva@example.com");
        clienteFisico.setEndereco("Rua A, 123");
        clienteFisico.setTelefone("123456789");
        clienteFisico.setUserName("joaosilva");
        clienteFisico.setPassword("senha123");

        clienteJuridico = new ClientePessoaJuridica();
        clienteJuridico.setIdCliente(2);
        clienteJuridico.setNome("Empresa X");
        clienteJuridico.setEmail("contato@empresax.com");
        clienteJuridico.setEndereco("Avenida B, 456");
        clienteJuridico.setTelefone("987654321");
        clienteJuridico.setUserName("empresax");
        clienteJuridico.setPassword("senha456");
    }

    @Test
    public void testSetIdCliente() {
        clienteFisico.setIdCliente(10);
        assertEquals(10, clienteFisico.getIdCliente());
    }

    @Test
    public void testSetNome() {
        clienteFisico.setNome("Maria");
        assertEquals("Maria", clienteFisico.getNome());
    }

    @Test
    public void testSetEmail() {
        clienteFisico.setEmail("maria@example.com");
        assertEquals("maria@example.com", clienteFisico.getEmail());
    }

    @Test
    public void testSetEndereco() {
        clienteFisico.setEndereco("Rua B, 456");
        assertEquals("Rua B, 456", clienteFisico.getEndereco());
    }

    @Test
    public void testSetTelefone() {
        clienteFisico.setTelefone("987654321");
        assertEquals("987654321", clienteFisico.getTelefone());
    }

    @Test
    public void testSetUserName() {
        clienteFisico.setUserName("mariasilva");
        assertEquals("mariasilva", clienteFisico.getUserName());
    }

    @Test
    public void testSetPassword() {
        clienteFisico.setPassword("novaSenha123");
        assertEquals("novaSenha123", clienteFisico.getPassword());
    }

    @Test
    public void testLogin() {
        assertTrue(clienteFisico.login("joaosilva", "senha123"));
        assertFalse(clienteFisico.login("joaosilva", "senhaErrada"));
    }

    @Test
    public void testAtualizaDados() {
        Cliente novoCliente = new ClientePessoaFisica();
        novoCliente.setNome("Ana Clara");
        novoCliente.setEmail("ana.clara@example.com");
        novoCliente.setEndereco("Rua C, 789");
        novoCliente.setTelefone("123123123");
        novoCliente.setUserName("anaclara");
        novoCliente.setPassword("senha789");

        clienteFisico.atualizaDados(novoCliente);
        assertEquals("Ana Clara", clienteFisico.getNome());
        assertEquals("ana.clara@example.com", clienteFisico.getEmail());
        assertEquals("Rua C, 789", clienteFisico.getEndereco());
        assertEquals("123123123", clienteFisico.getTelefone());
        assertEquals("anaclara", clienteFisico.getUserName());
        assertEquals("senha789", clienteFisico.getPassword());
    }

    @Test
    public void testValidarCPF() {
        ClientePessoaFisica clienteFisico = (ClientePessoaFisica) this.clienteFisico;
        assertTrue(clienteFisico.validarCPF("12345678909")); // Substitua por um CPF válido para testes reais
        assertFalse(clienteFisico.validarCPF("12345678900"));
    }

    @Test
    public void testValidarCNPJ() {
        ClientePessoaJuridica clienteJuridico = (ClientePessoaJuridica) this.clienteJuridico;
        assertTrue(clienteJuridico.validarCNPJ("12345678000195")); // Substitua por um CNPJ válido para testes reais
        assertFalse(clienteJuridico.validarCNPJ("12345678000100"));
    }
}
