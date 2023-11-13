package classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity

public class Classificacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClassificacao;

    private String cama;

    private boolean frigobar;


    private boolean arCondicionado;

    public Classificacao(){}

    public Classificacao(String cama, boolean frigobar, boolean arCondicionado) {
        this.cama = cama;
        this.frigobar = frigobar;
        this.arCondicionado = arCondicionado;
    }

    public Long getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(Long idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public String getCama() {
        return cama;
    }

    public void setCama(String cama) {
        this.cama = cama;
    }

    public boolean isFrigobar() {
        return frigobar;
    }

    public void setFrigobar(boolean frigobar) {
        this.frigobar = frigobar;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classificacao that = (Classificacao) o;
        return isFrigobar() == that.isFrigobar() && isArCondicionado() == that.isArCondicionado() && Objects.equals(getIdClassificacao(), that.getIdClassificacao()) && Objects.equals(getCama(), that.getCama());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdClassificacao(), getCama(), isFrigobar(), isArCondicionado());
    }

    @Override
    public String toString() {
        return "Classificacao{" +
                "idClassificacao=" + idClassificacao +
                ", cama='" + cama + '\'' +
                ", frigobar=" + frigobar +
                ", arCondicionado=" + arCondicionado +
                '}';
    }
}
