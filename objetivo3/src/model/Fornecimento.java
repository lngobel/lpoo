package model;

import java.util.Date;

public class Fornecimento {
    private Date data;
    private double valorTotal;
    private Produto produto;
    private Fornecedor fornecedor;
    private int quantidade;

    public Fornecimento() {
    }

    public Fornecimento(Produto produto, int quantidade, Date data, Fornecedor fornecedor) {
        this.data = data;
        this.produto = produto;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.valorTotal = produto.getPreco() * quantidade;
        produto.setQuantidade(produto.getQuantidade() + quantidade);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "\nFornecimento{" +
                "data=" + data +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                ", fornecedor=" + fornecedor +
                '}';
    }
}
