package me.cerratolabs.aunidosredirect.request;

import lombok.Data;
import lombok.ToString;
import me.cerratolabs.aunidosredirect.dto.Provincia;

@Data
@ToString
public class ProvinciaRequest {
    private Provincia provincia;
}