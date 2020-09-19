package me.cerratolabs.aunidosredirect.service;

import lombok.extern.slf4j.Slf4j;
import me.cerratolabs.aunidosredirect.db.service.ProvinciaDBService;
import me.cerratolabs.aunidosredirect.request.ProvinciaRequest;
import me.cerratolabs.aunidosredirect.response.ProvinciaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class ProvinciaService {

    @Autowired private ProvinciaDBService dbservice;

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/getSocialMedia", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ProvinciaResponse getSocialMedia(@RequestBody ProvinciaRequest request) {
        String idTransaction = "aunidos-redirect-" + System.currentTimeMillis() + "-getSocialMedia";
        ProvinciaResponse response = new ProvinciaResponse();
        response.setIdTransaccion(idTransaction);
        log.info("<getSocialMedia> " + idTransaction + " " +  request.toString());
        try {
            String url = dbservice.findURLByProvinciaAndAndSocialMedia(request.getProvincia(), request.getSocialMedia());
            if(ObjectUtils.isEmpty(url)) {
                response.setStatus(HttpStatus.NOT_FOUND);
            } else {
                log.info("</getSocialMedia> " + url);
                response.setUrl(url);
                response.setStatus(HttpStatus.OK);
            }
            return response;
        } catch (Exception e) {
            log.error("</getSocialMedia> " + idTransaction, e);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, idTransaction);
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/addNewURL", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ProvinciaResponse addNewURL(@RequestBody ProvinciaRequest request, HttpServletRequest re) {
        String idTransaction = "aunidos-redirect-" + System.currentTimeMillis() + "-addNewURL";
        ProvinciaResponse response = new ProvinciaResponse();
        response.setIdTransaccion(idTransaction);
        log.info("<addNewURL> " + idTransaction + " " +  request.toString());
        try {
            if(dbservice.checkIfPasswordIsCorrect(request.getPalabraSeguridad())) {
                this.dbservice.insertNewURL(request.getProvincia(), request.getSocialMedia(), request.getUrl());
                log.info("</addNewURL> " + request.getUrl());
                response.setStatus(HttpStatus.OK);

            } else {
                response.setStatus(HttpStatus.UNAUTHORIZED);
            }
            return response;
        } catch (Exception e) {
            log.error("</addNewURL> " + idTransaction, e);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, idTransaction);
        }
    }
}