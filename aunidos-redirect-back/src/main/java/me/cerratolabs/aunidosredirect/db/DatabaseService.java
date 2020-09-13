package me.cerratolabs.aunidosredirect.db;

import me.cerratolabs.aunidosredirect.dto.Provincia;
import me.cerratolabs.aunidosredirect.dto.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    @Autowired private ProvinciaRepository provinciaRepository;
    @Autowired private SocialMediaRepository socialMediaRepository;

    public SocialMedia findProvinciaByNameAndProvincia(String name, Integer provincia){
       return socialMediaRepository.findProvinciaByNameAndProvincia(name, provincia);
    }
    public Provincia findByName(String name){
        return provinciaRepository.findByName(name);
    }

    public Long findIdByName(String name){
        return provinciaRepository.findIdByName(name);
    }

}