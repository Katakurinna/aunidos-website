package me.cerratolabs.aunidosredirect.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Transaccion {
    private String idTransaccion;
    private ErrorTransaccion error;
}