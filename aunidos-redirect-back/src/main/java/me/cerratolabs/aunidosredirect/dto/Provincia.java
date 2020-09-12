package me.cerratolabs.aunidosredirect.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Table(name = "PROVINCIAS")
@Entity
public class Provincia implements Serializable {

    @Column(name = "ID")
    @Id private Long id;

    @Column(name = "NAME")
    private String name;

}