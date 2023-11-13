package testes;
import classes.*;
import dao.ClassificacaoDAO;
import dao.HospedeDAO;
import dao.PessoaDAO;
import dao.QuartoDAO;
import enums.Situacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        HospedeDAO hosp = new HospedeDAO();

        List<Endereco> lista = new LinkedList<>();
        lista.add(new Endereco("ruarua", "casacasa", "0000000"));
        lista.add(new Endereco("trtrtrtr", "casdfdacfdsa", "00sfddsf"));

        ArrayList<String> emails = new ArrayList<>();
        emails.add("hahahah@gmail");
        emails.add("kkkkgmail");

        List<Reserva> reservas= new LinkedList<>();

        Classificacao classi = new Classificacao("Cama King", true, true);

        Hospede teste = new Hospede("Adao", "0800", lista, "310714", "033200", new Date(), emails, reservas);

        List<Quarto> quartos = new LinkedList<>();
        Quarto quarto = new Quarto(true, 200, 5, Situacao.VAGO, classi );
        quartos.add(quarto);

        Reserva rev = new Reserva(new Date(122,11,31), new Date(123, 1,1), teste, quartos);

        reservas.add(rev);
        teste.setReservas(reservas);

        rev.setQuartos(quartos);

        hosp.salvar(teste);



       /* PessoaDAO pepe = new PessoaDAO();
        //Endereco end = new Endereco("ruarua", "casacasa", "0000000");
        List<Endereco> lista = new LinkedList<>();
        lista.add(new Endereco("ruarua", "casacasa", "0000000"));
        lista.add(new Endereco("trtrtrtr", "casdfdacfdsa", "00sfddsf"));
        Pessoa teste = new Pessoa("Alicate", "0800", lista);

        pepe.salvar(teste); */


    }


}