package controller;

import model.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class ObjetivoController {
    public static void main(String[] args) {
        System.out.println("CRIAÇÃO E IMPRESSÃO DAS INSTÂNCIAS:");
        ContaPoupanca cp1 = new ContaPoupanca(1000);
        ContaPoupanca cp2 = new ContaPoupanca(2000);
        ContaPoupanca cp3 = new ContaPoupanca(3000);
        System.out.print(cp1);
        System.out.print(cp2);
        System.out.println(cp3);

        ContaCorrente cc1 = new ContaCorrente(1000,100);
        ContaCorrente cc2 = new ContaCorrente(2000,400);
        ContaCorrente cc3 = new ContaCorrente(3000,600);
        System.out.print(cc1);
        System.out.print(cc2);
        System.out.println(cc3);

        Associado a1 = new Associado("Ana", 300);
        Associado a2 = new Associado("Maria", 600);
        Associado a3 = new Associado("Braga", 600);
        System.out.print(a1);
        System.out.print(a2);
        System.out.println(a3);

        System.out.println();

        System.out.println("CRIAÇÃO E IMPRESSÃO DAS COLEÇÕES:");
        List<Conta> contas = new ArrayList<>();
        contas.add(cp1);
        contas.add(cp2);
        contas.add(cp3);
        contas.add(cc1);
        contas.add(cc2);
        contas.add(cc3);
        System.out.println(contas);

        List<AssociadoVip> associados = new ArrayList<>();
        associados.add(a1);
        associados.add(a2);
        associados.add(a3);
        associados.add(cc1);
        associados.add(cc2);
        associados.add(cc3);
        System.out.println(associados);

        System.out.println();

        System.out.println("MOVIMENTANDO CONTA POUPANCA:");
        System.out.println("Saldo pré movimentação: " + cp1.getSaldo());
        cp1.deposita(1000);
        cp1.atualiza(5);
        cp1.saca(50);
        System.out.println("Saldo pós movimentação: " + cp1.getSaldo());

        System.out.println();

        System.out.println("MOVIMENTANDO CONTA CORRENTE:");
        System.out.println("Saldo pré movimentação: " + cc1.getSaldo());
        cc1.deposita(500);
        cc1.saca(400);
        System.out.println("Saldo pós movimentação: " + cc1.getSaldo());

        System.out.println();

        System.out.println("ORDENANDO ASSOCIADOS POR COTAS:");
        associados.sort(Comparator.comparing(AssociadoVip::getQdeCotas).reversed());
        System.out.println(associados);

        System.out.println();

        System.out.println("ASSOCIADO(S) COM MAIOR NÚMERO DE COTAS:");
        int maisCotas = associados.stream().max(Comparator.comparing(AssociadoVip::getQdeCotas)).get().getQdeCotas();
        for (AssociadoVip a:associados){
            if(a.getQdeCotas() == maisCotas)
                System.out.print(a);
        }

        System.out.println();
        System.out.println();

        System.out.println("ORDENANDO CONTAS POR SALDO:");
        contas.sort(Comparator.comparing(Conta::getSaldo).reversed());
        System.out.println(contas);

        System.out.println();

        System.out.println("ASSOCIADOS VIP COM CONTA:");
        for (AssociadoVip a:associados){
            if(a instanceof ContaCorrente)
                System.out.print(a);
        }

        System.out.println();
        System.out.println();

        System.out.println("CONTA(S) COM MAIOR SALDO:");
        double maiorSaldo = contas.stream().max(Comparator.comparing(Conta::getSaldo)).get().getSaldo();
        for (Conta c:contas){
            if(c.getSaldo() == maiorSaldo)
                System.out.print(c);
        }
    }

}
