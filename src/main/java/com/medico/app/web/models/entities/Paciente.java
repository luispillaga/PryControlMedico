package com.medico.app.web.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PACIENTE")
public class Paciente extends Persona implements Serializable {

    private static final long serialVersionUID = -2323333995012370735L;
    @Size(max = 500)
    @Column(name = "ALERGIAS")
    private String alergias;

    @Size(max = 5)
    @Column(name = "TIPOSANGRE")
    @NotEmpty
    private String tipoSangre;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Receta> recetas;

    public Paciente(){

    }

    public Paciente(Integer idPersona) {
        super();
        this.setIdPersona(idPersona);
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }
}
