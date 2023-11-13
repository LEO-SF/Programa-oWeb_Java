package testes;

import dao.EnderecoDAO;
import dao.HospedeDAO;
import classes.*;
import dao.QuartoDAO;
import dao.*;

import java.util.Date;

public class Teste {
    public static void main(String[] args) {

        HospedeDAO hosp = new HospedeDAO();

        EnderecoDAO end = new EnderecoDAO();

        QuartoDAO quart = new QuartoDAO();

        ReservaDAO rev = new ReservaDAO();

        ClassificacaoDAO clas = new ClassificacaoDAO();

        System.out.println(hosp.buscarPorNome("Adao", "033200") + "\n");

        System.out.println(end.buscarPorLogradouro("ruarua", "casacasa") + "\n");

        System.out.println(quart.buscarPorNumero(200) + "\n");

        Date dateinicio = new Date();
        dateinicio.setDate(31);
        dateinicio.setMonth(11);
        dateinicio.setYear(122);

        Date datefim = new Date();
        datefim.setDate(01);
        datefim.setMonth(01);
        datefim.setYear(123);


        System.out.println(rev.buscarIdPessoa(1L,1L));

        System.out.println("\n" + "Busca da classificacao"+ "\n");
        System.out.println(clas.buscarIdQuarto(1L, 1L));

        System.out.println("\n" + "Busca da classificacao por lista atributos"+ "\n");


        System.out.println(clas.buscarPorAr("Cama King"));













    }
}
