package me.cerratolabs.aunidosredirect.utils;

public class GenerarCodigo {

    public static String generar() {
        String codigo = Double.toString(Math.random()* 1000000);
        return codigo.substring(0,5);
    }
}