package classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "Hospede")
public class Hospede extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String rg;
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Date data_nasc;

    //MAPEAMENTO COLEÇÕES
    //Decidi por não dar um nome para a tabela, assim gerando "hospede_IDPESSOA" e "emails.
    //Como no diagrama, é um ArrayList e optei pelo por EAGER para carregar imediamente as associações
    //many ou com coleções
    @ElementCollection(fetch = FetchType.EAGER)
    private ArrayList<String> emails;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "hospede", cascade = CascadeType.ALL)
    @JoinColumn(name="idReserva")
    private List<Reserva> reservas;

    public Hospede(){
        super();
    }

    public Hospede(String nome, String telefone, List<Endereco> enderecos, String rg, String cpf, Date nascimento, ArrayList<String> emails, List<Reserva> reservas){
        super(nome, telefone, enderecos);
        this.rg = rg;
        this.cpf = cpf;
        this.data_nasc = nascimento;
        this.emails = emails;
        this.reservas = reservas;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hospede hospede = (Hospede) o;
        return Objects.equals(getRg(), hospede.getRg()) && Objects.equals(getCpf(), hospede.getCpf()) && Objects.equals(getData_nasc(), hospede.getData_nasc()) && Objects.equals(getEmails(), hospede.getEmails()) && Objects.equals(getReservas(), hospede.getReservas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRg(), getCpf(), getData_nasc(), getEmails(), getReservas());
    }

    @Override
    public String toString() {

        String emailsString = emails.toString().replaceAll("\\[|\\]", "");
        String reservasString = reservas.toString().replaceAll("\\[|\\]", "");

        return "Hospede: " + "\n" + super.toString() +
                "rg = " + rg + "\n" +
                "cpf = " + cpf + "\n" +
                "data_nasc = " + data_nasc + "\n" +
                "emails = " + emailsString + "\n" +
                "reservas = " + reservasString;
    }
}
