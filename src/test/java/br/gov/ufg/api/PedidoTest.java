package br.gov.ufg.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.gov.ufg.entity.Item;
import br.gov.ufg.entity.Pedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoTest {

    private Pedido pedido;
    private List<Item> itens;

    @BeforeEach
    public void setUp() {
        itens = new ArrayList<>();
        Item item1 = new Item();
        item1.setPrecoUnitario(10.0);
        item1.setQuantidade(2);

        Item item2 = new Item();
        item2.setPrecoUnitario(20.0);
        item2.setQuantidade(1);

        itens.add(item1);
        itens.add(item2);

        pedido = new Pedido();
        pedido.setItens(itens);
    }

    @Test
    public void testSetIdPedido() {
        pedido.setIdPedido(1);
        assertEquals(1, pedido.getIdPedido());
    }

    @Test
    public void testSetDataPedido() {
        Date data = new Date();
        pedido.setDataPedido(data);
        assertEquals(data, pedido.getDataPedido());
    }

    @Test
    public void testSetStatus() {
        pedido.setStatus("Pendente");
        assertEquals("Pendente", pedido.getStatus());
    }

    @Test
    public void testSetItens() {
        List<Item> novosItens = new ArrayList<>();
        Item item = new Item();
        item.setPrecoUnitario(30.0);
        item.setQuantidade(1);
        novosItens.add(item);
        pedido.setItens(novosItens);
        assertEquals(novosItens, pedido.getItens());
    }

    @Test
    public void testCalcularTotal() {
        double total = pedido.calcularTotal();
        assertEquals(40.0, total);
    }

    @Test
    public void testAtualizarStatus() {
        pedido.setStatus("Pendente");
        pedido.atualizarStatus("Enviado");
        assertEquals("Enviado", pedido.getStatus());
    }
}