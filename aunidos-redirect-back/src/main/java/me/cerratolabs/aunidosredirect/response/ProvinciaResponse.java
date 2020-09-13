package me.cerratolabs.aunidosredirect.response;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@ToString
public class ProvinciaResponse {
    private String url;
    private HttpStatus status;
    private String idTransaccion;
}