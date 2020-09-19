package me.cerratolabs.aunidosredirect.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cod_verificacion", schema = "aunidos_redirect", catalog = "")
public class CodVerificacion {
    private int id;
    private String dni;
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
    @Column(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
        CodVerificacion that = (CodVerificacion) o;
        return id == that.id &&
            Objects.equals(dni, that.dni) &&
            Objects.equals(codigo, that.codigo) &&
            Objects.equals(fecCad, that.fecCad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, codigo, fecCad);
    }
}