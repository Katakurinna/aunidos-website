package me.cerratolabs.aunidosredirect.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtils {

    public static String obtenerFechaFormateada() {
        return obtenerFechaFormateada(new Date());
    }

    public static String obtenerFechaFormateada(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        return formattedDate;
    }
}