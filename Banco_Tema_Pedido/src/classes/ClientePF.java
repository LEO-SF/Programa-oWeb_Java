package classes;

import dao.ClientePfDAO;
import dao.MinhaGen;

public final class ClientePF extends Cliente{

    private String cpf;

    private String telefone;

    public ClientePF(){
        super();
    }

    public ClientePF(String nome, String endereco, String cpf, String telefone) {
        super(-1, nome, endereco);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public ClientePF(int idClientePf, String nome, String endereco, String cpf, String telefone) {
        super(idClientePf, nome, endereco);
        this.cpf = cpf;
        this.telefone = telefone;
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

    @Override
    public String toString() {

        return  super.toString() + "3 - CPF = " + cpf + "\n" +
                "4 - Telefone= " + telefone+ "\n";
    }

    public ClientePF pesquisaCPFPf(String nomeBusca){
        return new ClientePfDAO().pesquisaCPF(nomeBusca);
    }
    public int deletarNomePf(String nome){
        return new ClientePfDAO().deletarNome(nome);
    }

    public int inserirPf(ClientePF cli){
        return new ClientePfDAO().inserir(cli);
    }

    public MinhaGen<ClientePF> listarTodosPf(){
        return new ClientePfDAO().listarTodos();
    }

    public int atualizarPf(ClientePF cli){
        return new ClientePfDAO().atualizar(cli);
    }

    public int deletar(ClientePF cli){
        return new ClientePfDAO().deletar(cli);
    }

    public ClientePF pesquisaID(int id){
        return new ClientePF().pesquisaID(id);
    }
}
