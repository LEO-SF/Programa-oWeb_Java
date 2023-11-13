package util;

public enum Situacao {
    ABERTO(1, "aberto"),
    CANCELADO(2, "cancelado"),
    ENTREGUE(3, "entregue");
    private final int id;
    private final String nome;

    private Situacao(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

}
