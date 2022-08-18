package model;

public class Associado implements AssociadoVip{
    private String nome;
    private int qdeCotas;
    private double valorCota;

    public Associado() {
    }

    public Associado(String nome) {
        this.nome = nome;
    }

    public Associado(String nome, int qdeCotas) {
        this.nome = nome;
        this.qdeCotas = qdeCotas;
    }

    public Associado(String nome, int qdeCotas, double valorCota) {
        this.nome = nome;
        this.qdeCotas = qdeCotas;
        this.valorCota = valorCota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQdeCotas(int qdeCotas) {
        this.qdeCotas = qdeCotas;
    }

    public double getValorCota() {
        return valorCota;
    }

    public void setValorCota(double valorCota) {
        this.valorCota = valorCota;
    }

    @Override
    public double lucros(int qdeCotas, double valorCota) {
        return qdeCotas * valorCota;
    }

    @Override
    public int getQdeCotas() {
        return this.qdeCotas;
    }

    @Override
    public String toString() {
        return "\nAssociado{" +
                "nome='" + nome + '\'' +
                ", qdeCotas=" + qdeCotas +
                ", valorCota=" + valorCota +
                '}';
    }
}
