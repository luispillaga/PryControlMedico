package com.medico.app.web.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "DETALLERECETA")
public class DetalleReceta implements Serializable {

    private static final long serialVersionUID = -1424455671427385165L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDETALLERECETA")
    private Integer idDetalleReceta;

    @Column(name = "CANTIDAD")
    @Min(value = 1)
    private Integer cantidad;

    @Column(name = "ACTIVO")
    private Boolean activo; // Si fue interrumpido no estaria activo

    @Size(max = 255)
    @Column(name = "OBSERVACION")
    private String observacion;

    @Column(name = "NUMEROTOMAS")
    @Min(value = 1)
    private Integer numeroTomas;

    @Column(name = "FRECUENCIA")
    @Min(value = 1)
    private Integer frecuencia;
    //Valor numérico del intervalo de frecuencia
    //ej:[8] horas, [3] veces al día, [1] mensual
    //se utilizará para realizar el cálculo de horas de cada dosis

    @Column(name = "TIPOFRECUENCIA")
    private Integer tipoFrecuencia;
    //Complemento para el cálculo de cada dosis, ej: horas, días, semanas
    //En el front-end es un 'combobox' con un valor enumerado

    @Size(max = 255)
    @Column(name = "POSOLOGIA")
    private String posologia;
    //Cantidad del medicamento que se va a suministrar al paciente en cada dosis
    //ej: 10ml , 1 pastilla, 1 aplicación, 1 inyección

    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaInicio;
    //Fecha y hora en que se suministra al paciente la 1ra dosis

    @JoinColumn(name = "IDMEDICAMENTO", referencedColumnName = "IDMEDICAMENTO")
    @ManyToOne
    private Medicamento medicamento;

    @Transient
    private Integer medicamentoId;

    @Transient
    private String descripcionTipoFrecuencia;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL) //creo la lista de dosis en detalles receta
    @JoinColumn(name = "IDDETALLERECETA")
    private List<Dosis> dosis;

    public DetalleReceta(Integer idDetalleReceta) {
        super();
        this.idDetalleReceta = idDetalleReceta;
    }

    public Integer getIdDetalleReceta() {
        return idDetalleReceta;
    }

    public void setIdDetalleReceta(Integer idDetalleReceta) {
        this.idDetalleReceta = idDetalleReceta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getNumeroTomas() {
        return numeroTomas;
    }

    public void setNumeroTomas(Integer numeroTomas) {
        this.numeroTomas = numeroTomas;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Integer getTipoFrecuencia() {
        return tipoFrecuencia;
    }

    public void setTipoFrecuencia(Integer tipoFrecuencia) {
        this.tipoFrecuencia = tipoFrecuencia;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Integer getMedicamentoId() {
        return medicamentoId;
    }

    public void setMedicamentoId(Integer medicamentoId) {
        this.medicamentoId = medicamentoId;
    }

    public String getDescripcionTipoFrecuencia() {
        switch(this.tipoFrecuencia) {
            case 0:
                return "Una sola vez";
            case 1:
                return "Horas";
            case 2:
                return "Diaria";
            case 3:
                return "Semanal";
            case 4:
                return "Mensual";
        }
        return "";
    }

    public void setDescripcionTipoFrecuencia(String descripcionTipoFrecuencia) {
        this.descripcionTipoFrecuencia = descripcionTipoFrecuencia;
    }

    public List<Dosis> getDosis() {
        return dosis;
    }

    public void setDosis(List<Dosis> dosis) {
        this.dosis = dosis;
    }
}
