package me.cerratolabs.aunidosredirect.service;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import me.cerratolabs.aunidosredirect.db.ProvinciasDAO;
import me.cerratolabs.aunidosredirect.dto.Provincia;
import me.cerratolabs.aunidosredirect.request.ProvinciaRequest;
import me.cerratolabs.aunidosredirect.response.ProvinciaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
@Slf4j
public class ProvinciaService {
    Logger LOGGER = LoggerFactory.getLogger(ProvinciaService.class);
    private ProvinciasDAO provinciasdao = new ProvinciasDAO();

    @CrossOrigin(origins = "*")
    @RequestMapping(path="/obtenerProvincia", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ProvinciaResponse obtenerProvincia(@RequestBody ProvinciaRequest request) throws SQLException {
        log.info("<obtenerProvincia> " + request.toString());
        ProvinciaResponse response = new ProvinciaResponse();
        log.info("</obtenerProvincia> " + response.toString());
        return this.provinciasdao.getSocialMedia(request);
    }
}