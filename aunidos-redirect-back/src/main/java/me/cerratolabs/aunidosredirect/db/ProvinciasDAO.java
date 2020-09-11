package me.cerratolabs.aunidosredirect.db;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import me.cerratolabs.aunidosredirect.configuration.AUnidosBeans;
import me.cerratolabs.aunidosredirect.dto.Provincia;
import me.cerratolabs.aunidosredirect.request.ProvinciaRequest;
import me.cerratolabs.aunidosredirect.response.ProvinciaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class ProvinciasDAO {

    @Autowired
    private DataSource dataSource;

    private Statement generateStatement() throws SQLException {
        return this.dataSource.getConnection().createStatement();
    }

    public ProvinciaResponse getSocialMedia(ProvinciaRequest request) throws SQLException {
        ProvinciaResponse response = new ProvinciaResponse();

        Provincia provincia = request.getProvincia();
        String consulta = "SELECT url from SOCIALMEDIA social INNER JOIN PROVINCIAS prov ON social.provincia = prov.id WHERE prov.name = '" + provincia.getName() + "' AND social.name = '" + provincia.getSocialMedia() + "'";
        log.info("<getSocialMedia> " + consulta);
        Statement st = generateStatement();
        ResultSet rs = st.executeQuery(consulta);
        if (rs.next()) {
            String url = rs.getString(rs.findColumn("url"));
            provincia.setUrl(url);
            log.info("</getSocialMedia> URL: " + url);
        } else {
            log.warn("</getSocialMedia> URL: null");
        }
        response.setProvincia(provincia);
        st.close();
        return response;
    }

    public boolean insertarProvincia(String name) {
        String consulta = "INSERT INTO PROVINCIAS VALUES (0,'" + name + "')";
        return false;
    }

    public boolean insertarSocialMedia(String provincia, String socialMedia, String url) {
        String consulta = "INSERT INTO SOCIALMEDIA VALUES (0, '" + socialMedia + "', '" + url + "' , (SELECT id from PROVINCIAS prov WHERE prov.name = '" + provincia + "'))";
        return false;
    }

}