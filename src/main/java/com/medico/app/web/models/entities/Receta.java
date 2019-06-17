package com.medico.app.web.models.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RECETA")
public class Receta implements Serializable {
    private static final long serialVersionUID = 451654424999168587L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRECETA")
    private Integer idReceta;

    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date fecha;

    @JoinColumn(name = "IDMEDICO", referencedColumnName = "IDPERSONA")
    @ManyToOne
    private Medico medico;

    @JoinColumn(name = "IDPACIENTE", referencedColumnName = "IDPERSONA")
    @ManyToOne
    private Paciente paciente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IDRECETA")
    private List<DetalleReceta> detalles;

    public Receta(){

    }

    public Receta(Integer idReceta){
        this.idReceta = idReceta;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<DetalleReceta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleReceta> detalles) {
        this.detalles = detalles;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
