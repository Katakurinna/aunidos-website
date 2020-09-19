package me.cerratolabs.aunidosredirect.db.service;

import me.cerratolabs.aunidosredirect.dto.Socio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CorreoService {
    @Autowired private JavaMailSender mailSender;

    public void enviarMensajeSimple(String email, String asunto, String mensaje) throws MailException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@aunidos.es");
        message.setTo(email);
        message.setSubject(asunto);
        message.setText(mensaje);
        mailSender.send(message);
    }

    public void enviarCodigoVerificacion(Socio socio, String codigo) throws MailException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@aunidos.es");
        message.setTo(socio.getEmail());
        message.setSubject("Codigo verificacion socios de aunidos.es");
        message.setText("¡Hola, " + socio.getNombre() + "! \n Tu codigo de verificacion es: " + codigo);
        mailSender.send(message);
    }

}