package view;

public enum OpcoesMenu {
    CADASTRAR(1, "Cadastrar ClientePF em Banco de dados"),
    PESQ(2, "Pesquisar ClientePF usando CPF"),
    PESQ_P(3, "Excluir Cliente usando nome"),
    LISTAR(4, "Listar todos os clientes"),

    SAIR(5, "Sair");
    ;

    private final int valor;
    private final String descricao;
    private OpcoesMenu(int valorOpcao, String descricao){
        valor = valorOpcao;
        this.descricao = descricao;
    }
    public int getValor(){
        return valor;
    }
    public String getDescricao(){
        return descricao;
    }
    @Override
    public String toString(){
        return this.getValor() + " - " + this.getDescricao();
    }
}
