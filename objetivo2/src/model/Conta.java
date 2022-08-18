package model;

public abstract class Conta {
    protected double saldo;

    public Conta() {
    }

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void deposita(double valor){

        saldo += valor;
    }

    public void saca(double valor){
        if(saldo >= valor)
            saldo -= valor;
        else
            System.out.println("Saldo Insuficiente!");
    }

    public void atualiza(double taxa){
        saldo += (saldo * (taxa / 100));
    }


}
