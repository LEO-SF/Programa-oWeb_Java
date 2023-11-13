import java.util.*;

import pedidos.*;
import pessoas.*;
import util.*;

import javax.swing.*;

public class Main {

        private static List<ClientePF> clientes = new ArrayList<>();
    public static void main(String[] args) {

        while(true){
            switch(montaMenu()){
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    pesquisarCliente();
                    break;
                case 3:
                    pesquisarClientePedido();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    listarClientesEmOrdem();
                    break;
                case 6:
                    sair();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção inválida!");
                    break;
            }
        }
    }

        private static void cadastrarCliente(){
             TreeSet<Pedido> pedidos = new TreeSet<>();

             ClientePF cliente = new ClientePF(
                     (JOptionPane.showInputDialog(null, "Informe o Nome do cliente:")),
                     (JOptionPane.showInputDialog(null, "Informe o endereço do cliente:")),
                     (JOptionPane.showInputDialog(null, "Informe o cpf do cliente:")),
                     (JOptionPane.showInputDialog(null, "Informe o telefone do cliente:")),
                     pedidos
             );

             clientes.add(cliente);

             int escolha = Integer.parseInt(JOptionPane.showInputDialog
                    (null,"Deseja registrar um pedido?" + "\n"+ "1 - Sim" + "\n" + "2 - Não"));
            while(escolha == 1) {
                 LinkedList<Item_Pedido> itens = new LinkedList<>();
                 double total = 0;
                 while (escolha == 1) {

                     Item_Pedido item = new Item_Pedido(
                             (Integer.parseInt(JOptionPane.showInputDialog(null, "informe a quantidade do item: "))),
                             (JOptionPane.showInputDialog(null, "Informe a descrição do item:")),
                             (Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor do item")))
                     );
                     total += item.getValor();
                     itens.addLast(item);
                     escolha = Integer.parseInt(JOptionPane.showInputDialog
                             (null, "Deseja inserir mais algum item ao pedido?" + "\n" + "1 - Sim" + "\n" + "2 - Não"));
                 }

                 String data = "";
                 do {
                     data = (JOptionPane.showInputDialog(null, "Informe a data do pedido:" + "\n" +"Datas válidas a partir de 01/01/2019 no formato DD/MM/YYYY"));
                 }while(Validador.isValido(data) == false);

                 Pedido pedido = new Pedido(
                         total,
                         data,
                         Pedido.getTotalN_pedido(),
                         Situacao.ABERTO,
                         itens
                 );
                 pedidos.add(pedido);

                 JOptionPane.showMessageDialog(null, "Pedido finalizado!" + "\n" + "Valor total: " + pedido.getValor());
                 escolha = Integer.parseInt(JOptionPane.showInputDialog
                         (null, "Deseja registrar um novo pedido?" + "\n" + "1 - Sim" + "\n" + "2 - Não"));
             }
             if(escolha == 2){
                 JOptionPane.showMessageDialog(null,"Cliente cadastrado!");
             }else{
                 JOptionPane.showMessageDialog(null,"Opção inválida!");
             }

        }

        private static void pesquisarCliente(){
            boolean encontrado = false;
            if(!clientes.isEmpty()) {
                String pesq = JOptionPane.showInputDialog(null, "Informe o Nome do cliente:");
                for (Cliente cli : clientes) {
                    if (pesq.equals(cli.getNome())) {
                        JOptionPane.showMessageDialog(null, cli.toString());
                        encontrado = true;
                    }
                }
                if(encontrado == false){
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado/registrado");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Não existem clientes cadastrados");
            }
    }

        private static void pesquisarClientePedido(){
            int pesq = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número do pedido:"));
            boolean encontrado = false;
            for (ClientePF cli : clientes) {
                if (!cli.getItens().isEmpty()) {
                    List<Pedido> list = new ArrayList<>(cli.getItens());
                    for (Pedido pedido: list) {
                        if (pesq == pedido.getNumero()) {
                            JOptionPane.showMessageDialog(null, "O pedido pertence ao cliente: " + cli.getNome()
                                    + "\n" + "Endereço: " + cli.getEndereco()+ "\n" + "CPF: " + cli.getCpf()+ "\n" + "Telefone: " + cli.getTelefone());
                            encontrado = true;
                            break;
                        }
                    }
                }
            }
            if(encontrado == false){
                JOptionPane.showMessageDialog(null, "Número de pedido inválido");
            }
        }

        private static void listarClientes(){
            if(!clientes.isEmpty()) {
                String aux = "";
                for (ClientePF cli : clientes) {
                      aux += "\n" + "Nome:" + cli.getNome()+ "\n" + "Endereço: " + cli.getEndereco()+ "\n" + "CPF: " + cli.getCpf()+ "\n" + "Telefone: " + cli.getTelefone() + "\n";
                }
                JOptionPane.showMessageDialog(null, aux);
            }else{
                JOptionPane.showMessageDialog(null, "Não existem clientes cadastrados");
            }
        }

        private static void listarClientesEmOrdem(){
            List<ClientePF> list = new ArrayList<>(clientes);
            Collections.sort(list);
            String aux = "";
            for (ClientePF cli : list) {
                aux += "\n" + "Nome:" + cli.getNome()+ "\n" + "Endereço: " + cli.getEndereco()+ "\n" + "CPF: " + cli.getCpf()+ "\n" + "Telefone: " + cli.getTelefone() + "\n";
            }
            JOptionPane.showMessageDialog(null, aux);
        }

        private static void sair(){
            JOptionPane.showMessageDialog(null,"Fechando o sistema");
            System.exit(0);
        }

        private static int montaMenu() {
        String str = "";
        for(OpcoesMenu opcaoMenu : OpcoesMenu.values())
            str +=  opcaoMenu.toString()+"\n";
        return Integer.parseInt(JOptionPane.showInputDialog(str));
    }

    }
