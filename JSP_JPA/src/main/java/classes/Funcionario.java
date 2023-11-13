package classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;

import dao.FuncionarioDAO;

import javax.persistence.*;


//MAPEAMENTO HERANÇA
//Optei pela Single_Table por haver apenas uma subclasse no diagrama.
//Dessa forma, para modelagem me pareceu mais adequado a junção das informações da superclasse e
//subclasse, bem como da extração das informações dos mesmos, apesar das desvantagens da inserção
//de campos nulos.
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tipo", length = 15,
        discriminatorType = DiscriminatorType.STRING)
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    private String nome;
    private String endereco;
    private String email;
    private double salario;
    private String cpf;
    
    public Funcionario(){}

    public Funcionario(String nome, String endereco, String email, double salario, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.salario = salario;
        this.cpf = cpf;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public boolean salvar() {
		return new FuncionarioDAO().salvar(this);
	}
	public List<Funcionario> buscarTodos(){
		return new FuncionarioDAO().buscarTodos();
	}
	public boolean atualizar(){
		return new FuncionarioDAO().atualizar(this);
	}
	public boolean remover(){
		return new FuncionarioDAO().remover(this.getIdFuncionario());
	}
	public Funcionario buscarID(){
		return new FuncionarioDAO().buscarID(this.getIdFuncionario());
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(getIdFuncionario(), that.getIdFuncionario()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getEndereco(), that.getEndereco()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getSalario(), that.getSalario()) && Objects.equals(getCpf(), that.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdFuncionario(), getNome(), getEndereco(), getEmail(), getSalario(), getCpf());
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", salario='" + salario + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
