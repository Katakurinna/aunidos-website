package me.cerratolabs.aunidosredirect.service;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import me.cerratolabs.aunidosredirect.dao.ProvinciasDAO;
import me.cerratolabs.aunidosredirect.db.DatabaseService;
import me.cerratolabs.aunidosredirect.dto.Provincia;
import me.cerratolabs.aunidosredirect.dto.SocialMedia;
import me.cerratolabs.aunidosredirect.request.ProvinciaRequest;
import me.cerratolabs.aunidosredirect.response.ProvinciaResponse;
import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@Slf4j
public class ProvinciaService {
    Logger LOGGER = LoggerFactory.getLogger(ProvinciaService.class);
    private ProvinciasDAO provinciasdao = new ProvinciasDAO();

    @Autowired private DatabaseService dbservice;
    @CrossOrigin(origins = "*")
    @RequestMapping(path="/getSocialMedia", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ProvinciaResponse getSocialMedia(@RequestBody ProvinciaRequest request) {
        /*try {
        log.info("<getSocialMedia> " + request.toString());
        ProvinciaResponse response = this.provinciasdao.getSocialMedia(request);
        log.info("</getSocialMedia> " + response.toString());
            return response;
        } catch (Exception e) {
            String idTransaction = "aunidos-redirect-" + System.currentTimeMillis() + "-getSocialMedia";
            log.error("</getSocialMedia> " + idTransaction, e);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, idTransaction);
        }*/
        ProvinciaResponse response = new ProvinciaResponse();
        SocialMedia socialMedia = request.getSocialMedia();
        Provincia provincia = dbservice.findByName(socialMedia.getProvincia().getName());
        log.info(provincia.toString());
        socialMedia = dbservice.findProvinciaByNameAndProvincia(socialMedia.getName(), provincia.getId());
        log.info(socialMedia.toString());
        response.setSocialMedia(socialMedia);
        return response;
    }

    
}