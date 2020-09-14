package me.cerratolabs.aunidosredirect.db;

import me.cerratolabs.aunidosredirect.dto.Password;
import me.cerratolabs.aunidosredirect.dto.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class DatabaseService {

    @Autowired URLRepository urlRepository;
    @Autowired PasswordRepository passwordRepository;

    public String findURLByProvinciaAndAndSocialMedia(Integer provincia, Integer socialMedia) {
        URL url = urlRepository.findURLByProvinciaAndAndSocialMedia(provincia, socialMedia);
        if (ObjectUtils.isEmpty(url)) return null;
        return url.getUrlOrNull();
    }

    public boolean checkIfPasswordIsCorrect(String password) {
        // Provincia 0: Contraseña global
        Password serverPassword = this.passwordRepository.findPasswordByProvincia(0);
        if (ObjectUtils.isEmpty(serverPassword)) return false;
        return password.equals(serverPassword.getPassword());
    }

    public void insertNewPassword(Integer provincia, Integer socialMedia, String enlace) {
        URL url = urlRepository.findURLByProvinciaAndAndSocialMedia(provincia, socialMedia);
        url.setUrl(enlace);
        this.urlRepository.saveAndFlush(url);
    }
}