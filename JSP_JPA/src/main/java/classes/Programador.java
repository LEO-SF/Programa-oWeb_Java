package classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;

import dao.ProgramadorDAO;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "Programador")
public class Programador extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    private String linguagem;
    private String projetos;
    
    public Programador(){}

    public Programador(String nome, String endereco, String email, double salario, String cpf, String linguagem, String projetos) {
        super(nome, endereco, email, salario, cpf);
        this.linguagem = linguagem;
        this.projetos = projetos;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public String getProjetos() {
        return projetos;
    }

    public void setProjetos(String projetos) {
        this.projetos = projetos;
    }
    
    public boolean salvar() {
		//manda salvar o objeto atual
		return new ProgramadorDAO().salvar(this);
	}
	public List<Programador> buscarTodosProg(){
		return new ProgramadorDAO().buscarTodosProg();
	}
	public boolean atualizar(){
		//manda editar/atualizar o objeto atual
		return new ProgramadorDAO().atualizar(this);
	}
	public boolean remover(){
		return new ProgramadorDAO().remover(super.getIdFuncionario());
	}
	public Programador buscarID(){
		return new ProgramadorDAO().buscarID(super.getIdFuncionario());
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Programador that = (Programador) o;
        return Objects.equals(getLinguagem(), that.getLinguagem()) && Objects.equals(getProjetos(), that.getProjetos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLinguagem(), getProjetos());
    }

    @Override
    public String toString() {
        return "Programador{" + super.toString() + 
                "linguagem='" + linguagem + '\'' +
                ", projetos='" + projetos + '\'' +
                '}';
    }
}
