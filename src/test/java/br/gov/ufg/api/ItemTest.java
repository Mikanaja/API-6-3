package br.gov.ufg.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.gov.ufg.entity.Item;

public class ItemTest {

    private Item item;

    @BeforeEach
    public void setUp() {
        item = new Item();
    }

    @Test
    public void testSetIdItem() {
        item.setIdItem(1);
        assertEquals(1, item.getIdItem());
    }

    @Test
    public void testSetQuantidade() {
        item.setQuantidade(5);
        assertEquals(5, item.getQuantidade());
    }

    @Test
    public void testSetPrecoUnitario() {
        item.setPrecoUnitario(10.0);
        assertEquals(10.0, item.getPrecoUnitario());
    }

    @Test
    public void testCalcularSubtotal() {
        item.setQuantidade(3);
        item.setPrecoUnitario(20.0);
        double subtotal = item.calcularSubtotal();
        assertEquals(60.0, subtotal);
    }
}
