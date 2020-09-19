package me.cerratolabs.aunidosredirect.service;

import lombok.extern.slf4j.Slf4j;
import me.cerratolabs.aunidosredirect.db.service.ProvinciaDBService;
import me.cerratolabs.aunidosredirect.request.CrearSocioRequest;
import me.cerratolabs.aunidosredirect.response.CrearSocioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/socios")
public class SocioService {

    @Autowired private ProvinciaDBService dbservice;

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/crearSocio", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public CrearSocioResponse crearSocio(CrearSocioRequest request) {
        return null;
    }
}