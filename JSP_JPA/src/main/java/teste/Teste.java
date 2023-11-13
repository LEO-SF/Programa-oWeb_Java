package teste;

import classes.Programador;
import classes.Usuario;
import dao.ProgramadorDAO;
import dao.UsuarioDAO;

public class Teste {
	
	public static void main(String[] args) {
		
		//Pequeno teste para listar um programador e testar login de usuario
		//Depois de executar, comentar drop and create
		
		UsuarioDAO user = new UsuarioDAO();
		
		Usuario teste = new Usuario("leofreitas@gmail.com", "12345678");
		
		user.salvar(teste);
		
		ProgramadorDAO prog = new ProgramadorDAO();
		
		Programador Pteste = new Programador("Leon", "Av Nilo 15", "leo_teste@yahoo.com.br", 
				4000.00, "12345678911", "Java Pleno", "Projeto e-commerce roupas, Projeto e-commerce bazar");
		
		prog.salvar(Pteste);
	}

}
