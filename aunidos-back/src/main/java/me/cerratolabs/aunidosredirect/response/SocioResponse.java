package me.cerratolabs.aunidosredirect.response;

import lombok.Data;
import lombok.ToString;
import me.cerratolabs.aunidosredirect.dto.Socio;

import java.util.List;

@Data
@ToString
public class SocioResponse extends GenericResponse {
    private List<Socio> socios;
}