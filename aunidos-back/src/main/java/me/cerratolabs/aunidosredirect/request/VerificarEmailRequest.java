package me.cerratolabs.aunidosredirect.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VerificarEmailRequest extends GenericRequest {
    private String dni;
    private String codigo;
}