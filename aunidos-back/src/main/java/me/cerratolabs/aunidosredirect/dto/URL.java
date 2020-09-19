package me.cerratolabs.aunidosredirect.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@ToString
@Table("url")
@Entity
public class URL implements Serializable {
    @Column(name = "ID") @Id private Integer id;
    @Column(name = "provincia") private Integer provincia;
    @Column(name = "social_media") private Integer socialMedia;
    @Column(name = "url") private String url;

    public String getUrlOrNull(){
        if(url == null) return null;
        if(url.length() < 1) return null;
        return url;
    }
}