package me.cerratolabs.aunidosredirect.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Table(name = "SOCIALMEDIA")
@Entity
public class SocialMedia implements Serializable {

    @Column(name = "ID")
    @Id private Integer id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "PROVINCIA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Provincia provincia;

    @Column(name = "URL")
    private String url;


}