package pedidos;

import util.Situacao;
import util.Validador;

import java.util.LinkedList;
import java.util.Objects;

public class Pedido implements Validador, Comparable<Pedido> {

    private double valor;

    private String data;

    private int numero;

    public static int n_pedido = 1;

    private Situacao situação;

    private LinkedList<Item_Pedido> itens = new LinkedList<>();

    public Pedido(){}

    public Pedido(double valor, String data, int numero, Situacao situação, LinkedList<Item_Pedido> itens) {
        this.valor = valor;
        this.data = data;
        this.numero = numero;
        this.situação = situação;
        this.itens = itens;
        n_pedido++;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) { this.numero = n_pedido; }
    public static int getTotalN_pedido() {
        return n_pedido;
    }

    public static void setN_pedido(int n_pedido) { Pedido.n_pedido = n_pedido; }

    public Situacao getSituação() {
        return situação;
    }

    public void setSituação(Situacao situação) { this.situação = situação; }
    public LinkedList<Item_Pedido> getItens() {
        return itens;
    }

    public void setItens(LinkedList<Item_Pedido> itens) {
        this.itens = itens;
    }


    @Override
    public String toString() {

        int i = 1;
        String str = "";
        if(!itens.isEmpty()) {
            for (Item_Pedido item : itens) {
                str += "\n" + "Item " + i + "\n";
                str += item.toString();
                i++;
            }
        }

        String aux = "";

        aux += "Número do pedido: " + numero + "\n";
        aux += (valor == 0) ? "Valor = " + "\n" : "Valor = " + valor + "\n";
        aux += (data == null) ? "Data = " + "\n" : "Data = " + data + "\n";
        aux += (situação == null) ? "Situação = " + "\n" : "Situação = " + situação;
        aux += str;

        return aux;
    }

    @Override
    public int compareTo(Pedido obj) {
        if(obj.getValor() == this.getValor()) return 0;
        if(obj.getValor() > this.getValor()) return -1;
        return 1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        return valor == other.valor;
    }
}
