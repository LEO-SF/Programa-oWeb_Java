package classes;

import enums.Situacao;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Quarto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuarto;


    private boolean isOcupado;

    private int numero;

    private int capacidadeMax;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy="quartos")
    private List<Reserva> reservas;

    //MAPEAMENTO ENUM
    //Minha estratégia de uso para o ENUM foi da anotação tipo EnumType.STRING para
    //facilitar a leitura e pesquisa da situação do quarto quanto a estar "ocupado", "vago" ou "em manutenção",
    //apesar da desvantagem de não poder alterar o nome das constantes.
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @OneToOne (orphanRemoval = true, cascade = CascadeType.ALL)
    private Classificacao classificacao;

    public Quarto(){}

    public Quarto(boolean isOcupado, int numero, int capacidadeMax, Situacao situacao, Classificacao classificacao) {
        this.isOcupado = isOcupado;
        this.numero = numero;
        this.capacidadeMax = capacidadeMax;
        this.situacao = situacao;
        this.classificacao = classificacao;
    }

    public Long getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public boolean isOcupado() {
        return isOcupado;
    }

    public void setOcupado(boolean ocupado) {
        isOcupado = ocupado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quarto quarto = (Quarto) o;
        return isOcupado() == quarto.isOcupado() && getNumero() == quarto.getNumero() && getCapacidadeMax() == quarto.getCapacidadeMax() && Objects.equals(getIdQuarto(), quarto.getIdQuarto()) && Objects.equals(getReservas(), quarto.getReservas()) && getSituacao() == quarto.getSituacao() && Objects.equals(getClassificacao(), quarto.getClassificacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdQuarto(), isOcupado(), getNumero(), getCapacidadeMax(), getReservas(), getSituacao(), getClassificacao());
    }

    @Override
    public String toString() {

        int i = 1;
        String str = "";
        if(!reservas.isEmpty()) {
            for (Reserva rev : reservas) {
                str += "\n" + "Reserva " + i + "\n";
                str += rev.getIdReserva();
                i++;
            }
        }

        return "Quarto{" +
                "idQuarto=" + idQuarto +
                ", isOcupado=" + isOcupado +
                ", numero=" + numero +
                ", capacidadeMax=" + capacidadeMax +
                "reservas = " + str +
                ", situacao=" + situacao +
                ", classificacao=" + classificacao +
                '}';
    }
}
