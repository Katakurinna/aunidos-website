package me.cerratolabs.aunidosredirect.exceptions;

public class CrearSocioException extends Exception {

    public static CrearSocioException campoNoValido(String campo) {
        return new CrearSocioException("El campo " + campo + " no puede ser nulo");
    }

    public CrearSocioException(String message) {
        super(message);
    }

    public CrearSocioException() {
        super("El socio introducido no es válido");
    }
}