package control;

import dao.ClienteDAO;
import model.Cliente;

import java.util.List;
import java.util.Scanner;

public class ClienteController {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao = 0;
        do{
            System.out.print("\n|------- MENU CLIENTE -------|\n");
            System.out.print("\n1. Inserir novo cliente" +
                    "\n2. Atualizar um cliente" +
                    "\n3. Listar todos clientes" +
                    "\n4. Buscar cliente pelo código" +
                    "\n5. Buscar cliente pelo email" +
                    "\n6. Buscar cliente pelo nome" +
                    "\n7. Deletar cliente" +
                    "\n0. Sair" +
                    "\nEscolha uma opção:");
            opcao = input.nextInt();
            input.nextLine();
            switch(opcao) {
                case 1:
                    inserir();
                    break;
                case 2:
                    atualizar();
                    break;
                case 3:
                    selectClientes();
                    break;
                case 4:
                    selectClienteById();
                    break;
                case 5:
                    selectClienteByEmail();
                    break;
                case 6:
                    selectClienteByNome();
                    break;
                case 7:
                    deleteCliente();
                    break;
                default:
                    if(opcao != 0)
                        System.out.println("Opção inválida!");
            }
        }while(opcao != 0);
    }

    //opção 1
    private static void inserir(){
        Cliente cliente = new Cliente();
        System.out.println("\n|***** CADASTRAR CLIENTE *****|");
        System.out.print("Nome do cliente: ");
        cliente.setNome(input.nextLine());
        System.out.print("\nEndereço do cliente: ");
        cliente.setEndereco(input.nextLine());
        System.out.print("\nCEP do cliente: ");
        cliente.setCep(input.nextLine());
        System.out.print("\nTelefone do cliente: ");
        cliente.setTelefone(input.nextLine());
        System.out.print("\nEmail do cliente:");
        cliente.setEmail(input.nextLine());
        if(ClienteDAO.insertCliente(cliente))
            System.out.println("\nCliente inserido com sucesso!");
        else
            System.out.println("\nNão foi possível inserir o cliente!");
    }

    //opção 2
    private static void atualizar(){
        System.out.println("|***** ALTERAR CLIENTE *****|");
        System.out.println("\nCódigo do cliente: ");
        int codigo = input.nextInt();
        int alt = 0;
        Cliente cliente = ClienteDAO.selectClienteById(codigo);
        if(cliente == null)
            System.out.println("Código inexistente!");
        else{
            System.out.println("Nome: " + cliente.getNome());
            System.out.print("Deseja alterar? (1.Sim / 2.Não): ");
            if(input.nextInt() == 1){
                input.nextLine();
                System.out.print("Novo nome: ");
                cliente.setNome(input.nextLine());
                alt = 1;
            }
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.print("Deseja alterar? (1.Sim / 2.Não): ");
            if(input.nextInt() == 1){
                input.nextLine();
                System.out.print("Novo endereço: ");
                cliente.setEndereco(input.nextLine());
                alt = 1;
            }
            System.out.println("CEP: " + cliente.getCep());
            System.out.print("Deseja alterar? (1.Sim / 2.Não): ");
            if(input.nextInt() == 1){
                input.nextLine();
                System.out.print("Novo CEP: ");
                cliente.setCep(input.nextLine());
                alt = 1;
            }
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.print("Deseja alterar? (1.Sim / 2.Não): ");
            if(input.nextInt() == 1){
                input.nextLine();
                System.out.print("Novo telefone: ");
                cliente.setTelefone(input.nextLine());
                alt = 1;
            }
            System.out.println("Email: " + cliente.getEmail());
            System.out.print("Deseja alterar? (1.Sim / 2.Não): ");
            if(input.nextInt() == 1){
                input.nextLine();
                System.out.print("Novo email: ");
                cliente.setEmail(input.nextLine());
                alt = 1;
            }

            if(alt == 1){
                if(ClienteDAO.updateCliente(cliente))
                    System.out.println("Cliente atualizado com sucesso!");
                else
                    System.out.println("Não foi possível atualizar o cliente!");
            }
            else
                System.out.println("Nenhuma informação foi alterada!");
        }
    }

    //opção 3
    private static void selectClientes(){
        System.out.println("|***** LISTA DE CLIENTES *****|");
        System.out.println(ClienteDAO.selectClientes());
    }

    //opção 4
    private static void selectClienteById(){
        System.out.println("|***** PESQUISAR CLIENTE *****|");
        System.out.print("Código do cliente: ");
        int codigo = input.nextInt();
        Cliente cliente = ClienteDAO.selectClienteById(codigo);
        if(cliente == null)
            System.out.println("Código inexistente!");
        else
            System.out.println(cliente);
    }

    //opção 5
    private static void selectClienteByEmail(){
        System.out.println("|***** PESQUISAR CLIENTE *****|");
        System.out.print("Email do cliente: ");
        String email = input.nextLine();
        Cliente cliente = ClienteDAO.selectClienteByEmail(email);
        if(cliente == null)
            System.out.println("Email inexistente!");
        else
            System.out.println(cliente);
    }

    //opção 6
    private static void selectClienteByNome(){
        System.out.println("|***** PESQUISAR CLIENTE *****|");
        System.out.print("Nome do cliente: ");
        String nome = input.nextLine();
        List<Cliente> clienteList = ClienteDAO.selectClienteByName(nome);
        if(clienteList == null)
            System.out.println("Nome inexistente!");
        else
            System.out.println(clienteList);
    }

    //opção 7
    private static void deleteCliente(){
        System.out.println("|***** DELETAR CLIENTE *****|");
        System.out.print("Id do cliente: ");
        int codigo = input.nextInt();
        Cliente cliente = ClienteDAO.selectClienteById(codigo);
        if(cliente == null)
            System.out.println("Código inexistente!");
        else{
            if(ClienteDAO.deleteCliente(codigo))
                System.out.println("Cliente excluído com sucesso!");
            else
                System.out.println("Não foi possível excluir o cliente!");
        }
    }
}
