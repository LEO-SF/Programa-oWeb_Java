package pedidos;
import util.Validador;

public final class Item_Pedido implements Validador {

    private int quantidade;

    private String descricao;

    private double valor;

    public Item_Pedido(){}

    public Item_Pedido(int quantidade, String descricao, double valor) {
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return  "Quantidade = " + quantidade +
                ", Descricao = " + descricao  +
                ", Valor = " + valor;
    }
}
