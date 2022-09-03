package model;

public class Item {
    private int codItem;
    private double desconto;
    private int quantidade;
    private Produto produto;
    private double valor;

    public Item() {
    }

    public Item(int codItem, double desconto, int quantidade, Produto produto) {
        this.codItem = codItem;
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.produto = produto;
        this.valor = (quantidade * produto.getPreco()) - desconto;
        if(produto.getQuantidade() >= quantidade)
            produto.setQuantidade(produto.getQuantidade() - quantidade);
        else {
            throw new EstoqueInsuficienteException();
        }
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "\nItem{" +
                "codItem=" + codItem +
                ", desconto=" + desconto +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", produto=" + produto +
                '}';
    }
}
