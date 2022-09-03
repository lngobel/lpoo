package model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int  numero;
    private Date data;
    private double valor;
    private Tipo status;
    Vendedor vendedor;
    List<Item> itemList = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(int numero, Date data, Tipo status, Vendedor vendedor, List<Item> itemList) {
        this.numero = numero;
        this.data = data;
        this.status = status;
        this.vendedor = vendedor;
        this.itemList = itemList;
        double val = 0;
        for(Item item : itemList){
            val = val + item.getValor();
        }
        this.valor = val;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Tipo getStatus() {
        return status;
    }

    public void setStatus(Tipo status) {
        this.status = status;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
        double val = 0;
        for(Item item : itemList){
            val = val + item.getValor();
        }
        this.valor = val;
    }

    @Override
    public String toString() {
        return "\nPedido{" +
                "numero=" + numero +
                ", data=" + data +
                ", valor=" + valor +
                ", status=" + status +
                ", vendedor=" + vendedor +
                ", itemList=" + itemList +
                '}';
    }
}
