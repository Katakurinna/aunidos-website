package me.cerratolabs.aunidosredirect.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cod_verificacion", schema = "aunidos_redirect")
public class CodVerificacion implements Serializable {
    private int id;
    private String email;
    private String codigo;
    private Date fecCad;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "fec_cad")
    public Date getFecCad() {
        return fecCad;
    }

    public void setFecCad(Date fecCad) {
        this.fecCad = fecCad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodVerificacion codVerificacion = (CodVerificacion) o;
        return id == codVerificacion.id &&
            Objects.equals(email, codVerificacion.email) &&
            Objects.equals(codigo, codVerificacion.codigo) &&
            Objects.equals(fecCad, codVerificacion.fecCad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, codigo, fecCad);
    }
}