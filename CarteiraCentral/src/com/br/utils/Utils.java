package com.br.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Utils {
    
    public static void maximizar(JDialog dialog){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        screen = new Dimension((int) screen.getWidth(), (int) screen.getHeight() - 40);
        dialog.setSize(screen);
        dialog.setLocationRelativeTo(null);
    }
    
    public static String converterDouble(double valor){
        return new DecimalFormat("#0.00").format(valor);
    }
    
    public static String converterData(Date data){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
    public void InserirIcone(JFrame frame){
        try {
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/com/br/imagens/carteitacentral.png"));;
        } catch (Exception e) {
            Msg.informacao(frame, "Não foi possivel gerar o icone!");
        }
    }
    
}

    

