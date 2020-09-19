package me.cerratolabs.aunidosredirect.request;

import lombok.Data;
import lombok.ToString;
import me.cerratolabs.aunidosredirect.dto.Transaccion;
@Data
@ToString
public class GenericRequest {
    private Transaccion transaccion;
}