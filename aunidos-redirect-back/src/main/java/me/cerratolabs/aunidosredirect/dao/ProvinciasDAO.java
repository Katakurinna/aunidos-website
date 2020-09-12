package me.cerratolabs.aunidosredirect.dao;

import lombok.extern.slf4j.Slf4j;
import me.cerratolabs.aunidosredirect.db.ProvinciaRepository;
import me.cerratolabs.aunidosredirect.db.SocialMediaRepository;
import me.cerratolabs.aunidosredirect.dto.SocialMedia;
import me.cerratolabs.aunidosredirect.request.ProvinciaRequest;
import me.cerratolabs.aunidosredirect.response.ProvinciaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Slf4j
@Component
public class ProvinciasDAO {

    /*public ProvinciaResponse getSocialMedia(ProvinciaRequest request) throws SQLException {
        ProvinciaResponse response = new ProvinciaResponse();

        SocialMedia provincia = request.getSocialMedia();
        // String consulta = "SELECT url from SOCIALMEDIA social INNER JOIN PROVINCIAS prov ON social.provincia = prov.id WHERE prov.name = '" + provincia.getName() + "' AND social.name = '" + provincia.getSocialMedia() + "'";
        log.info("<getSocialMedia> " + consulta);
        // Statement st = generateStatement();
        ResultSet rs = st.executeQuery(consulta);
        if (rs.next()) {
            String url = rs.getString(rs.findColumn("url"));
            provincia.setUrl(url);
            log.info("</getSocialMedia> URL: " + url);
        } else {
            log.warn("</getSocialMedia> URL: null");
        }
        response.setSocialMedia(provincia);
        st.close();
        return response;
    }*/
    /*public ProvinciaResponse getSocialMedia(ProvinciaRequest request) throws SQLException {
        ProvinciaResponse response = new ProvinciaResponse();
        SocialMedia socialMedia = request.getSocialMedia();
        Long idProvincia = provinciaRepository.findIdByName(socialMedia.getProvincia().getName());
        socialMedia = socialMediaRepository.findProvinciaByNameAndProvincia(socialMedia.getName(), idProvincia);
        response.setSocialMedia(socialMedia);
        return response;
    }*/

    public boolean insertarProvincia(String name) {
        String consulta = "INSERT INTO PROVINCIAS VALUES (0,'" + name + "')";
        return false;
    }

    public boolean insertarSocialMedia(String provincia, String socialMedia, String url) {
        String consulta = "INSERT INTO SOCIALMEDIA VALUES (0, '" + socialMedia + "', '" + url + "' , (SELECT id from PROVINCIAS prov WHERE prov.name = '" + provincia + "'))";
        return false;
    }

}