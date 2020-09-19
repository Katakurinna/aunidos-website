package me.cerratolabs.aunidosredirect.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@ToString
public class ErrorTransaccion {
    private HttpStatus error;
    private String mensaje;
}