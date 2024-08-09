package br.gov.ufg.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.gov.ufg.entity.Produto;

public class ProdutoTest {

    private Produto produto;

    @BeforeEach
    public void setUp() {
        produto = new Produto();
    }

    @Test
    public void testSetIdProduto() {
        produto.setIdProduto(1);
        assertEquals(1, produto.getIdProduto());
    }

    @Test
    public void testSetNome() {
        produto.setNome("Camiseta");
        assertEquals("Camiseta", produto.getNome());
    }

    @Test
    public void testSetDescricao() {
        produto.setDescricao("Camiseta de algodão");
        assertEquals("Camiseta de algodão", produto.getDescricao());
    }

    @Test
    public void testSetPreco() {
        produto.setPreco(29.99);
        assertEquals(29.99, produto.getPreco());
    }

    @Test
    public void testSetEstoque() {
        produto.setEstoque(100);
        assertEquals(100, produto.getEstoque());
    }

    @Test
    public void testSetImagem() {
        produto.setImagem("imagem.jpg");
        assertEquals("imagem.jpg", produto.getImagem());
    }

    @Test
    public void testAtualizaEstoque() {
        produto.setEstoque(100);
        produto.atualizaEstoque(50);
        assertEquals(150, produto.getEstoque());
    }

    @Test
    public void testAtualizaPreco() {
        produto.setPreco(29.99);
        produto.atualizaPreco(39.99);
        assertEquals(39.99, produto.getPreco());
    }

    @Test
    public void testConstrutorCompleto() {
        Produto novoProduto = new Produto(1, "Camiseta", "Camiseta de algodão", 29.99, 100, "imagem.jpg");
        assertEquals(1, novoProduto.getIdProduto());
        assertEquals("Camiseta", novoProduto.getNome());
        assertEquals("Camiseta de algodão", novoProduto.getDescricao());
        assertEquals(29.99, novoProduto.getPreco());
        assertEquals(100, novoProduto.getEstoque());
        assertEquals("imagem.jpg", novoProduto.getImagem());
    }
}