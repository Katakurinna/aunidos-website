package me.cerratolabs.aunidosredirect.request;

import lombok.Data;
import lombok.ToString;
import me.cerratolabs.aunidosredirect.dto.Socio;

import java.util.List;

@Data
@ToString
public class SocioRequest extends GenericRequest {
    private List<Socio> socios;
}