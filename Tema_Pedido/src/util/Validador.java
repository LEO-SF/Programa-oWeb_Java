package util;

import pedidos.Pedido;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface Validador {

    public static boolean isValido(String data) {
        try {
            Date teste = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            Date validador = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019");
            if(teste.after(validador)){
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Datas válidas somente a partir de 01/01/2019");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null,"Formato inválido");
        }
        return false;
    }


}
