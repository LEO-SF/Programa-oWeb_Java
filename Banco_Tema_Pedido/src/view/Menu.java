package view;

import classes.*;
import java.util.*;
import dao.*;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    static ClientePF aux = new ClientePF();
    public static void main(String[] args) {

        while(true){
            montaMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch(opcao){
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    pesquisarCliente();
                    break;
                case 3:
                    excluir();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    sair();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

        private static void cadastrarCliente(){
            System.out.println("=== Cadastro de ClientePF ===");
            System.out.print("Informe o nome da pessoa: ");
            String nome = scanner.nextLine();
            System.out.print("Informe o endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Informe o cpf: ");
            String cpf = scanner.nextLine();
            System.out.print("Informe o telefone: ");
            String telefone = scanner.nextLine();

            ClientePF cli = new ClientePF(nome, endereco, cpf, telefone);

            if (aux.inserirPf(cli) == -1)
                System.out.println("\n" + "Erro ao inserir Cliente!" + "\n");
            else
                System.out.println("\n" + "Cliente cadastrado com sucesso!!" + "\n");

        }
        private static void pesquisarCliente(){
            System.out.printf("\n" + "Informe um CPF: ");
            String nomeBusca = scanner.next();
            ClientePF cli = aux.pesquisaCPFPf(nomeBusca);
            if(cli != null){
                System.out.println("\n" + cli);
            }else{
                System.out.println("\n" + "Cliente não encontrado/inexistente" + "\n");
            }

        }

        private static void excluir(){
            System.out.printf("Informe o nome do cliente a deletar: ");
            String deleta = scanner.next();
            if(aux.deletarNomePf(deleta) >= 1){
                System.out.println("Cliente deletado com sucesso!!"+"\n");
            };
        }

        private static void listarClientes(){
            MinhaGen<ClientePF> lista = aux.listarTodosPf();
            lista.listarTodos();
        }

        private static void sair(){
            System.out.println("Fechando o sistema");
            System.exit(0);
        }

        public static void montaMenu() {
            System.out.println("=== MENU ===");
        for (OpcoesMenu opcao : OpcoesMenu.values()) {
            System.out.println(opcao);
        }
        System.out.print("Escolha uma opção: ");
    }
}
