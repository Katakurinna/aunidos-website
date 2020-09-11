package me.cerratolabs.aunidosredirect.service;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import me.cerratolabs.aunidosredirect.db.ProvinciasDAO;
import me.cerratolabs.aunidosredirect.request.ProvinciaRequest;
import me.cerratolabs.aunidosredirect.response.ProvinciaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@Slf4j
public class ProvinciaService {
    Logger LOGGER = LoggerFactory.getLogger(ProvinciaService.class);
    private ProvinciasDAO provinciasdao = new ProvinciasDAO();

    @CrossOrigin(origins = "*")
    @RequestMapping(path="/obtenerProvincia", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ProvinciaResponse obtenerProvincia(@RequestBody ProvinciaRequest request) {
        try {
        log.info("<obtenerProvincia> " + request.toString());
        ProvinciaResponse response = this.provinciasdao.getSocialMedia(request);
        log.info("</obtenerProvincia> " + response.toString());
            return response;
        } catch (Exception e) {
            String idTransaction = "aunidos_redirect:" + System.currentTimeMillis() + ":";
            log.error("</obtenerProvincia> " + idTransaction, e);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, idTransaction);
        }
    }
}