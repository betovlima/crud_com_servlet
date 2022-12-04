package br.com.projetoweb.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

    public static String getCurrencyValue(Double valorAluguel) {
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(localeBR);
        return numberFormat.format(valorAluguel);
    }
}
