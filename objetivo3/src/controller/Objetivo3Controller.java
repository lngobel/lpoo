package controller;

import model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Objetivo3Controller {
    public static void main(String[] args) {
        Produto produto1 = new Produto(1,"Camiseta do Grêmio",25,250.00);
        Produto produto2 = new Produto(2,"Jaqueta do Grêmio",10,300.00);

        System.out.println("ESTOQUE DO PRODUTO1 PRÉ VENDA: " + produto1.getQuantidade());
        System.out.println("ESTOQUE DO PRODUTO2 PRÉ VENDA: " + produto2.getQuantidade());

        List<Produto> produtoList = new ArrayList<>();
        produtoList.add(produto1);
        produtoList.add(produto2);

        Fornecedor fornecedor = new Fornecedor(1,"netshoes@contato.com","Netshoes",produtoList);
        produto1.addFornecedorList(fornecedor);
        produto2.addFornecedorList(fornecedor);

        Item item1 = new Item(1,0,5,produto1);
        Item item2 = new Item(2,0,5,produto2);
        produto1.addItemList(item1);
        produto2.addItemList(item2);

        List<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        List<Item> itemList2 = new ArrayList<>();
        itemList2.add(item2);

        Date data = new Date(1620227200L * 1000);

        Vendedor vendedor = new Vendedor(1,"Lucas","Fernando Osório","Três Vendas","96070-300","Pelotas","RS","Shopping");
        Pedido pedido1 = new Pedido(1,data,Tipo.ATENDIDO,vendedor,itemList1);
        Pedido pedido2 = new Pedido(2,data,Tipo.ATENDIDO,vendedor,itemList2);

        List<Pedido> pedidoList = new ArrayList<>();
        pedidoList.add(pedido1);
        pedidoList.add(pedido2);

        System.out.println(); // ESPAÇO EM BRANCO

        System.out.println("PEDIDOS:");
        System.out.println(pedidoList);

        System.out.println(); // ESPAÇO EM BRANCO

        System.out.println("ESTOQUE DO PRODUTO1 PÓS VENDA: " + produto1.getQuantidade());
        System.out.println("ESTOQUE DO PRODUTO2 PÓS VENDA: " + produto2.getQuantidade());

        System.out.println(); // ESPAÇO EM BRANCO
        System.out.println(); // ESPAÇO EM BRANCO

        System.out.println("FORNECIMENTOS:");
        Fornecimento fornecimento1 = new Fornecimento(produto1,50,data,fornecedor);
        Fornecimento fornecimento2 = new Fornecimento(produto2,25,data,fornecedor);
        List<Fornecimento> fornecimentoList = new ArrayList<>();
        fornecimentoList.add(fornecimento1);
        fornecimentoList.add(fornecimento2);

        System.out.println(fornecimentoList);

        System.out.println(); // ESPAÇO EM BRANCO

        System.out.println("ESTOQUE DO PRODUTO1 PÓS FORNECIMENTO: " + produto1.getQuantidade());
        System.out.println("ESTOQUE DO PRODUTO2 PÓS FORNECIMENTO: " + produto2.getQuantidade());

        System.out.println(); // ESPAÇO EM BRANCO

        double custo = 0;
        for(Fornecimento fornecimento:fornecimentoList){
            custo += fornecimento.getValorTotal();
        }
        System.out.println("CUSTO TOTAL DOS FORNECIMENTOS: " + custo);
    }
}
