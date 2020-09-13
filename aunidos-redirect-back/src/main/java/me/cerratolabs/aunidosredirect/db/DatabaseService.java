package me.cerratolabs.aunidosredirect.db;

import me.cerratolabs.aunidosredirect.dto.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class DatabaseService {

    @Autowired URLRepository urlRepository;

    public String findURLByProvinciaAndAndSocialMedia(Integer provincia, Integer socialMedia) {
        URL url = urlRepository.findURLByProvinciaAndAndSocialMedia(provincia, socialMedia);
        if (ObjectUtils.isEmpty(url)) return null;
        return url.getUrlOrNull();
    }
}