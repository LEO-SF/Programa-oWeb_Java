package classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Reserva implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    //MAPEAMENTO DATE
    //Como consta no diagrama, o retorno é do tipo Date para entrada e saída dos hospedes
    //ignorando hora/minuto/segundo, então decidi pelo uso do TemporalType.DATE para mapeamento das datas,
    //o qual se faz necessário a anotação para mapeamento diferente do LocalDate

    @Temporal(TemporalType.DATE)
    private Date data_inicio;

    @Temporal(TemporalType.DATE)
    private Date data_fim;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idPessoa")
    private Hospede hospede;

    @ManyToMany (fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
    @JoinTable( name="Quarto_Reserva",
            joinColumns={ @JoinColumn(name="idReserva")},
            inverseJoinColumns={@JoinColumn(name="idQuarto")})
    private List<Quarto> quartos;

    public Reserva(){}

    public Reserva(Date data_inicio, Date data_fim, Hospede hospede, List<Quarto> quartos){
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.hospede = hospede;
        this.quartos = quartos;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(getIdReserva(), reserva.getIdReserva()) && Objects.equals(getData_inicio(), reserva.getData_inicio()) && Objects.equals(getData_fim(), reserva.getData_fim()) && Objects.equals(getHospede(), reserva.getHospede()) && Objects.equals(getQuartos(), reserva.getQuartos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdReserva(), getData_inicio(), getData_fim());
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", data_inicio=" + data_inicio +
                ", data_fim=" + data_fim +
                //Tinha hospede como retorno
                ", quartos=" + quartos +
                '}';
    }
}
