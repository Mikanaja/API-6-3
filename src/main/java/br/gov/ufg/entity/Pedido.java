package br.gov.ufg.entity;

import java.util.Date;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Date dataPedido;
    private String status;
    private List<Item> itens;

    public double calcularTotal() {
        return itens.stream().mapToDouble(Item::calcularSubtotal).sum();
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }

    // Getters e Setters
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}