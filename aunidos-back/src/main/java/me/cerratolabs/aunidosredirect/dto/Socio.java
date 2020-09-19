package me.cerratolabs.aunidosredirect.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "socio", schema = "aunidos_redirect")
public class Socio {
    private String dni;
    private String apellidos;
    private String nombre;
    private String telMovil;
    private String telFax;
    private String email;
    private String domicilio;
    private String poblacion;
    private String codPostal;
    private Integer provincia;
    private String gremio;
    private Date fecAlta;
    private Date fecBaja;
    private Date fecUltModificacion;
    private Byte verificado;
    private Byte emailConfirmado;

    @Id
    @Column(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "apellidos")
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "tel_movil")
    public String getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(String telMovil) {
        this.telMovil = telMovil;
    }

    @Basic
    @Column(name = "tel_fax")
    public String getTelFax() {
        return telFax;
    }

    public void setTelFax(String telFax) {
        this.telFax = telFax;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "domicilio")
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Basic
    @Column(name = "poblacion")
    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Basic
    @Column(name = "cod_postal")
    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    @Basic
    @Column(name = "provincia")
    public Integer getProvincia() {
        return provincia;
    }

    public void setProvincia(Integer provincia) {
        this.provincia = provincia;
    }

    @Basic
    @Column(name = "gremio")
    public String getGremio() {
        return gremio;
    }

    public void setGremio(String gremio) {
        this.gremio = gremio;
    }

    @Basic
    @Column(name = "fec_alta")
    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    @Basic
    @Column(name = "fec_baja")
    public Date getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(Date fecBaja) {
        this.fecBaja = fecBaja;
    }

    @Basic
    @Column(name = "fec_ult_modificacion")
    public Date getFecUltModificacion() {
        return fecUltModificacion;
    }

    public void setFecUltModificacion(Date fecUltModificacion) {
        this.fecUltModificacion = fecUltModificacion;
    }

    @Basic
    @Column(name = "verificado")
    public Byte getVerificado() {
        return verificado;
    }

    public void setVerificado(Byte verificado) {
        this.verificado = verificado;
    }

    @Basic
    @Column(name = "email_confirmado")
    public Byte getEmailConfirmado() {
        return emailConfirmado;
    }

    public void setEmailConfirmado(Byte emailConfirmado) {
        this.emailConfirmado = emailConfirmado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return Objects.equals(dni, socio.dni) &&
            Objects.equals(apellidos, socio.apellidos) &&
            Objects.equals(nombre, socio.nombre) &&
            Objects.equals(telMovil, socio.telMovil) &&
            Objects.equals(telFax, socio.telFax) &&
            Objects.equals(email, socio.email) &&
            Objects.equals(domicilio, socio.domicilio) &&
            Objects.equals(poblacion, socio.poblacion) &&
            Objects.equals(codPostal, socio.codPostal) &&
            Objects.equals(provincia, socio.provincia) &&
            Objects.equals(gremio, socio.gremio) &&
            Objects.equals(fecAlta, socio.fecAlta) &&
            Objects.equals(fecBaja, socio.fecBaja) &&
            Objects.equals(fecUltModificacion, socio.fecUltModificacion) &&
            Objects.equals(verificado, socio.verificado) &&
            Objects.equals(emailConfirmado, socio.emailConfirmado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, apellidos, nombre, telMovil, telFax, email, domicilio, poblacion, codPostal, provincia, gremio, fecAlta, fecBaja, fecUltModificacion, verificado, emailConfirmado);
    }
}