package classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;

import dao.UsuarioDAO;

import javax.persistence.*;

@Entity
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String email;

    private String senha;
    
    public Usuario(){}

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean salvar() {
		return new UsuarioDAO().salvar(this);
	}
	public List<Usuario> buscarTodos(){
		return new UsuarioDAO().buscarTodos();
	}
	public boolean atualizar(){
		return new UsuarioDAO().atualizar(this);
	}
	public boolean remover(){
		return new UsuarioDAO().remover(this.getIdUsuario());
	}
	public Usuario buscarID(){
		return new UsuarioDAO().buscarID(this.getIdUsuario());
	}
	public boolean login(String email, String senha) {
	    return new UsuarioDAO().login(email, senha);
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getIdUsuario(), usuario.getIdUsuario()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getSenha(), usuario.getSenha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUsuario(), getEmail(), getSenha());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
