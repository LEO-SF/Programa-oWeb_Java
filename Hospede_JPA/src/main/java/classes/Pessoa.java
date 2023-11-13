package classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.*;


//MAPEAMENTO HERANÇA
//Optei pela Single_Table por haver apenas uma subclasse no diagrama.
//Dessa forma, para modelagem me pareceu mais adequado a junção das informações da superclasse e
//subclasse, bem como da extração das informações dos mesmos, apesar das desvantagens da inserção
//de campos nulos.
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tipo", length = 10,
        discriminatorType = DiscriminatorType.STRING)
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    @Column(name = "Tipo", updatable=false)
    private String tipo;

    private String nome;
    private String telefone;

    @OneToMany (fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name="idPessoa")
    private List<Endereco> enderecos;

    public Pessoa(){

    }

    public Pessoa( String nome, String telefone, List<Endereco> enderecos) {
        this.nome = nome;
        this.telefone = telefone;
        this.enderecos = enderecos;
    }

    public Long getIdUsuario() {
        return idPessoa;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idPessoa = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(idPessoa, pessoa.idPessoa) && Objects.equals(getTipo(), pessoa.getTipo()) && Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getTelefone(), pessoa.getTelefone()) && Objects.equals(getEnderecos(), pessoa.getEnderecos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, getTipo(), getNome(), getTelefone(), getEnderecos());
    }

    @Override
    public String toString() {

        String enderecosString = enderecos.toString().replaceAll("\\[|\\]", "").replace(", ", "");

        return  "idPessoa = " + idPessoa + "\n" +
                "tipo = " + tipo + "\n" +
                "nome= " + nome + "\n" +
                "telefone = " + telefone + "\n" +
                "enderecos = " + "\n" + enderecosString + "\n";
    }
}
