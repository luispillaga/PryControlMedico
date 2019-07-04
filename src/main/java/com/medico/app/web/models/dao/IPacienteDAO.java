package com.medico.app.web.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.medico.app.web.models.entities.Paciente;

public interface IPacienteDAO extends JpaRepository<Paciente, Integer> {

}
