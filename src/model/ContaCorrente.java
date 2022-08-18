package model;

public class ContaCorrente extends Conta implements AssociadoVip{
    private int qdeCotas;
    private double valorCota;

    public ContaCorrente(double saldo, int qdeCotas) {
        super(saldo);
        this.qdeCotas = qdeCotas;
    }

    public ContaCorrente(double saldo, int qdeCotas, double valorCota) {
        super(saldo);
        this.qdeCotas = qdeCotas;
        this.valorCota = valorCota;
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
        return qdeCotas;
    }

    @Override
    public String toString() {
        return "\nContaCorrente{" +
                "qdeCotas=" + qdeCotas +
                ", valorCota=" + valorCota +
                ", saldo=" + saldo +
                '}';
    }
}
