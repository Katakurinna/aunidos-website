package me.cerratolabs.aunidosredirect.service;

import lombok.extern.slf4j.Slf4j;
import me.cerratolabs.aunidosredirect.db.DatabaseService;
import me.cerratolabs.aunidosredirect.request.ProvinciaRequest;
import me.cerratolabs.aunidosredirect.response.ProvinciaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@Slf4j
public class ProvinciaService {

    @Autowired private DatabaseService dbservice;

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/getSocialMedia", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ProvinciaResponse getSocialMedia(@RequestBody ProvinciaRequest request) {
        /*try {
        log.info("<getSocialMedia> " + request.toString());
        ProvinciaResponse response = this.provinciasdao.getSocialMedia(request);
        log.info("</getSocialMedia> " + response.toString());
            return response;
        } catch (Exception e) {

            log.error("</getSocialMedia> " + idTransaction, e);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, idTransaction);
        }*/

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


}