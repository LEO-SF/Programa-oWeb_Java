package pessoas;
import pedidos.Pedido;
import pedidos.Item_Pedido;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public final class ClientePF extends Cliente implements Comparable<ClientePF>{

    private String cpf;

    private String telefone;

    TreeSet<Pedido> pedidos;

    public ClientePF(){
        super();
    }

    public ClientePF(String nome, String endereco, String cpf, String telefone, TreeSet<Pedido> pedidos) {
        super(nome, endereco);
        this.cpf = cpf;
        this.telefone = telefone;
        this.pedidos = pedidos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TreeSet<Pedido> getItens() {
        return pedidos;
    }

    public void setItens(TreeSet<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        String aux = "Não há pedidos cadastrados";
        if(!pedidos.isEmpty()) {
            aux = "\n" + "";
            for (Pedido pedido : pedidos) {
                    aux += pedido.toString();
                    aux += "\n\n";
            }
        }

        return  super.toString() + "3 - CPF = " + cpf + "\n" +
                "4 - Telefone= " + telefone+ "\n" +
                "5 - Pedidos = " + "\n" + aux;
    }

    @Override
    public int compareTo(ClientePF obj) {
        return super.getNome().toLowerCase().compareTo(obj.getNome().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome().toLowerCase());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ClientePF cliente = (ClientePF) obj;
        return Objects.equals(getNome().toLowerCase(), cliente.getNome().toLowerCase());
    }
}
