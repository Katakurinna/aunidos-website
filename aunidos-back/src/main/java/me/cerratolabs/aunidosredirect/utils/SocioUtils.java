package me.cerratolabs.aunidosredirect.utils;

import me.cerratolabs.aunidosredirect.dto.Socio;
import me.cerratolabs.aunidosredirect.exceptions.CrearSocioException;

public class SocioUtils {
    public static Boolean verificarSocio(Socio socio) throws CrearSocioException {
        if (socio == null) throw new CrearSocioException();
        if (socio.getDni() == null) throw CrearSocioException.campoNoValido("DNI");
        if (socio.getApellidos() == null) throw CrearSocioException.campoNoValido("Apellidos");
        if (socio.getNombre() == null) throw CrearSocioException.campoNoValido("Nombre");
        if (socio.getTelMovil() == null) throw CrearSocioException.campoNoValido("Telefono movil");
        if (socio.getEmail() == null) throw CrearSocioException.campoNoValido("email");
        if (socio.getDomicilio() == null) throw CrearSocioException.campoNoValido("domicilio");
        if (socio.getPoblacion() == null) throw CrearSocioException.campoNoValido("poblacion");
        if (socio.getProvincia() == null) throw CrearSocioException.campoNoValido("provincia");
        if (socio.getCodPostal() == null) throw CrearSocioException.campoNoValido("codigo postal");
        return true;
    }
}

