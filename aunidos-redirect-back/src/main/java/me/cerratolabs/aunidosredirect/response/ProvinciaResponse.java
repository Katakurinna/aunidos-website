package me.cerratolabs.aunidosredirect.response;

import lombok.Data;
import lombok.ToString;
import me.cerratolabs.aunidosredirect.dto.SocialMedia;
import org.springframework.http.HttpStatus;

@Data
@ToString
public class ProvinciaResponse {
    private SocialMedia socialMedia;
    private HttpStatus status;
    private String idTransaccion;
}