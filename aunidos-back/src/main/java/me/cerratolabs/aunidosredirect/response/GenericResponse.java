package me.cerratolabs.aunidosredirect.response;

import lombok.Data;
import lombok.ToString;
import me.cerratolabs.aunidosredirect.dto.Transaccion;

@Data
@ToString
public class GenericResponse {
    private Transaccion transaccion;
}