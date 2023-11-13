package classes;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Endereco implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    private String  logradouro;
    private String  complemento;
    private String  CEP;

    public Endereco(){}

    public Endereco(String logradouro, String complemento, String CEP) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.CEP = CEP;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(getIdEndereco(), endereco.getIdEndereco()) && Objects.equals(getLogradouro(), endereco.getLogradouro()) && Objects.equals(getComplemento(), endereco.getComplemento()) && Objects.equals(getCEP(), endereco.getCEP());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEndereco(), getLogradouro(), getComplemento(), getCEP());
    }

    @Override
    public String toString() {
        
        return  "idEndereco = " + idEndereco + "\n" +
                "logradouro = " + logradouro + "\n" +
                "complemento = " + complemento + "\n" +
                "CEP = " + CEP + "\n";
    }
}
