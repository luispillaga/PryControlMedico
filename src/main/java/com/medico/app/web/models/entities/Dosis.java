package com.medico.app.web.models.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "DOSIS")
public class Dosis implements Serializable {

    private static final long serialVersionUID = 5590578722187637753L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDOSIS")
    private Integer idDosis;

    @Column(name = "FECHAHORA")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar fechaHora;

    @Column(name = "NUMERO")
    @Min(value = 1)
    private Integer numero;

    @Size(max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "ESTADO")
    @Min(value = 0)
    private Integer estado;

    public Dosis() {
    }

    public Integer getIdDosis() {
        return idDosis;
    }

    public void setIdDosis(Integer idDosis) {
        this.idDosis = idDosis;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
