package model;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
    private int cnpj;
    private String contato;
    private String nome;
    List<Produto> produtoList = new ArrayList<>();

    public Fornecedor() {
    }

    public Fornecedor(int cnpj, String contato, String nome, List<Produto> produtoList) {
        this.cnpj = cnpj;
        this.contato = contato;
        this.nome = nome;
        this.produtoList = produtoList;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public String toString() {
        return "\nFornecedor{" +
                "cnpj=" + cnpj +
                ", contato='" + contato + '\'' +
                ", nome='" + nome +
                '}';
    }
}
