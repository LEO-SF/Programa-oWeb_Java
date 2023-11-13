package classes;

import dao.*;

public class Cliente {

    private int idCliente;
    private String nome;
    private String endereco;

    public Cliente(){}
    public Cliente(String nome, String endereco){
        this.idCliente = -1;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Cliente(int idCliente, String nome, String endereco) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public int getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return  "1 - Nome = " + nome + "\n" + "2 - Endereco = " + endereco + "\n";
    }

    public int inserir() {
        return new ClienteDAO().inserir(this);
    }
    public static MinhaGen<Cliente> listarTodos(){
        return new ClienteDAO().listarTodos();
    }
    public int atualizar(){
        return new ClienteDAO().atualizar(this);
    }
    public int deletar(){
        return new ClienteDAO().deletar(this);
    }
    public Cliente pesquisaID(){
        return new ClienteDAO().pesquisarID(this.getIdCliente());
    }
}
