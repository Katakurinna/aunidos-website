package me.cerratolabs.aunidosredirect.service;

import lombok.extern.slf4j.Slf4j;
import me.cerratolabs.aunidosredirect.db.service.CorreoService;
import me.cerratolabs.aunidosredirect.db.service.SocioDBService;
import me.cerratolabs.aunidosredirect.dto.CodVerificacion;
import me.cerratolabs.aunidosredirect.dto.ErrorTransaccion;
import me.cerratolabs.aunidosredirect.dto.Socio;
import me.cerratolabs.aunidosredirect.dto.Transaccion;
import me.cerratolabs.aunidosredirect.exceptions.CrearSocioException;
import me.cerratolabs.aunidosredirect.request.SocioRequest;
import me.cerratolabs.aunidosredirect.request.VerificarEmailRequest;
import me.cerratolabs.aunidosredirect.response.SocioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/socios")
public class SocioService {

    @Autowired private SocioDBService dbservice;
    @Autowired private CorreoService correoService;

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/crearSocio", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public SocioResponse crearSocio(@RequestBody SocioRequest request, ) {
        SocioResponse response = new SocioResponse();
        Transaccion transaccion = new Transaccion();
        transaccion.setIdTransaccion(request.getTransaccion().getIdTransaccion());
        response.setTransaccion(transaccion);
        try {
            for (Socio socio : request.getSocios()) {
                this.dbservice.crearSocio(socio);
                CodVerificacion codVerificacion = this.dbservice.generarCodigoVerificacion(socio.getDni());
                this.correoService.enviarCodigoVerificacion(socio, codVerificacion.getCodigo());
            }
        } catch(CrearSocioException e) {
            ErrorTransaccion errorTransaccion = new ErrorTransaccion();
            errorTransaccion.setError(HttpStatus.CONFLICT);
            errorTransaccion.setMensaje(e.getMessage());
            transaccion.setError(errorTransaccion);
            e.printStackTrace();
        } catch (Exception e) {
            ErrorTransaccion errorTransaccion = new ErrorTransaccion();
            errorTransaccion.setError(HttpStatus.INTERNAL_SERVER_ERROR);
            errorTransaccion.setMensaje(e.getMessage());
            transaccion.setError(errorTransaccion);
            e.printStackTrace();
        }
        return response;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/verificarEmailSocio", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public SocioResponse verificarEmailSocio(@RequestBody VerificarEmailRequest request) {
        SocioResponse response = new SocioResponse();
        Transaccion transaccion = new Transaccion();
        transaccion.setIdTransaccion(request.getTransaccion().getIdTransaccion());
        response.setTransaccion(transaccion);
        try {
                boolean verificado = this.dbservice.verificarEmailSocio(request.getDni(),request.getCodigo());
                if(!verificado) {
                    ErrorTransaccion errorTransaccion = new ErrorTransaccion();
                    errorTransaccion.setError(HttpStatus.NOT_FOUND);
                    errorTransaccion.setMensaje("El código o DNI no son correctos.");
                    transaccion.setError(errorTransaccion);
                }
        } catch(CrearSocioException e) {
            ErrorTransaccion errorTransaccion = new ErrorTransaccion();
            errorTransaccion.setError(HttpStatus.CONFLICT);
            errorTransaccion.setMensaje(e.getMessage());
            transaccion.setError(errorTransaccion);
            e.printStackTrace();
        } catch (Exception e) {
            ErrorTransaccion errorTransaccion = new ErrorTransaccion();
            errorTransaccion.setError(HttpStatus.INTERNAL_SERVER_ERROR);
            errorTransaccion.setMensaje(e.getMessage());
            transaccion.setError(errorTransaccion);
            e.printStackTrace();
        }
        return response;
    }
}