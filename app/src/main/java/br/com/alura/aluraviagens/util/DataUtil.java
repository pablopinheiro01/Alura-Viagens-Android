package br.com.alura.aluraviagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_MES = "dd/MM";

    public static String periodoEmTexto(int dias) {
        //data de hoje
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(DIA_MES);
        String dataFormatadaDeIda = formatoBrasileiro.format(dataIda.getTime());
        String dataFormatadaDeVolta = formatoBrasileiro.format(dataVolta.getTime());
        return dataFormatadaDeIda + " - " + dataFormatadaDeVolta + " de " + dataVolta.get(Calendar.YEAR);
    }

}
