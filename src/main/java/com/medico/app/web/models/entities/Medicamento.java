package com.medico.app.web.models.entities;

import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MEDICAMENTO")
public class Medicamento implements Serializable {

    private static final long serialVersionUID = -1435002172723564312L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMEDICAMENTO")
    private Integer idMedicamento;

    @Column(name = "COMPONENTEACTIVO")
    @Size(max = 255)
    private String componenteActivo;

    @Column(name = "CONCENTRACION")
    @Size(max = 35)
    @NotEmpty
    private String concentracion;

    @Column(name = "NOMBRECOMERCIAL")
    @Size(max = 65)
    @NotEmpty
    private String nombreComercial;

    @Column(name = "PRECIO")
    @Digits(integer=8, fraction=2)
    private float precio;

    @Column(name = "FECHACADUCIDAD")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCaducidad;

    @JoinColumn(name="IDVIAADMINISTRACION", referencedColumnName = "IDVIAADMINISTRACION")
    @ManyToOne
    private ViaAdministracion viaAdministracion;

    public Medicamento() {
        super();
    }

    public Medicamento(Integer idMedicamento) {
        super();
        this.idMedicamento = idMedicamento;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getComponenteActivo() {
        return componenteActivo;
    }

    public void setComponenteActivo(String componenteActivo) {
        this.componenteActivo = componenteActivo;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public ViaAdministracion getViaAdministracion() {
        return viaAdministracion;
    }

    public void setViaAdministracion(ViaAdministracion viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
    }

}
