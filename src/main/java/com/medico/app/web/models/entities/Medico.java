package com.medico.app.web.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "MEDICO")
public class Medico extends Persona implements Serializable {

    private static final long serialVersionUID = 3975524080621706378L;
    @Size(max = 35)
    @Column(name = "LICENCIA")
    @NotEmpty
    private String licencia;

    @Size(max = 255)
    @Column(name = "ESPECIALIDAD")
    private String especialidad;

    @OneToMany(mappedBy = "medico", fetch = FetchType.LAZY)
    private List<Receta> recetas;

    public Medico(){

    }

    public Medico(Integer idPersona) {
        super();
        this.setIdPersona(idPersona);
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }
}
