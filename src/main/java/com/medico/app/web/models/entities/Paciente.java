package com.medico.app.web.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Entity
@Table(name="PACIENTE")
public class Paciente extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;

	@Size(max = 255)
	@Column(name = "ALERGIAS")
	private String alergias;
	
	@Size(max = 3)
	@Column(name = "TIPOSANGRE")
	private String tipoSangre;
	
	@Size(max = 255)
	@Column(name = "ANTECEDENTES")
	private String antecedentes;
	
	@Size(max = 25)
	@Column(name = "CREADOPOR")
	private String creadoPor;

	@Column(name = "CREADOEN")
	private LocalDateTime creadoEn;

	@Column(name = "NACIMIENTO")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "{date}")
	@NotNull
	private LocalDate nacimiento;

    @JsonIgnore
	@OneToMany(mappedBy="paciente", fetch=FetchType.LAZY)//LAZY, trae los valores de los atributos y no todo el listado 
	private List<Receta> recetas;

	public Paciente() {
		super();
	}

	public Paciente(Integer Id) {
		super();
		this.setIdpersona(Id);
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

	public String getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	@PrePersist
    public void prePersist() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        creadoPor = auth.getName();
        creadoEn = LocalDateTime.now();
    }
	
}