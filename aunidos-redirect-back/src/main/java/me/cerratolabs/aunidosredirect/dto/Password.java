package me.cerratolabs.aunidosredirect.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ToString
@Table("password")
@Entity
public class Password {
    @Column(name = "provincia") @Id private Integer provincia;
    @Column(name = "password") private String password;
}