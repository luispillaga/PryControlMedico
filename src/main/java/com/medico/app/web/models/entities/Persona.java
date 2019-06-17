package com.medico.app.web.models.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPERSONA")
    private Integer idPersona;

    @Size(max = 10)
    @Column(name = "CEDULA")
    @NotEmpty
    private String cedula;

    @Size(max = 40)
    @Column(name = "NOMBRE")
    @NotEmpty
    private String nombre;

    @Size(max = 40)
    @Column(name = "APELLIDO")
    @NotEmpty
    private String apellido;

    @Column(name = "NACIMIENTO")
    @Past
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nacimiento;

    @Size(max = 15)
    @Column(name = "TELEFONO")
    @NotEmpty
    private String telefono;

    @Size(max = 35)
    @Column(name = "EMAIL")
    @NotEmpty
    @Email
    private String email;

    public Persona() {
    }

    public Persona(Integer idPersona){
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
