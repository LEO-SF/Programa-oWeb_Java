package util;

public enum OpcoesMenu {
    CADASTRAR(1, "Cadastrar cliente"),
    PESQ(2, "Pesquisar cliente"),
    PESQ_P(3, "Pesquisar cliente - por pedido"),
    LISTAR(4, "Listar todos os clientes"),
    LISTAR_NOME(5, "Listar clientes - ordenados"),

    SAIR(6, "Sair");
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
