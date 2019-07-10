package com.medico.app.web.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medico.app.web.models.entities.Paciente;

  public interface IPacienteDAO extends JpaRepository<Paciente, Integer> {
	@Query(value = "SELECT * FROM paciente,receta WHERE receta.idpaciente=paciente.idpersona AND receta.activo=true", nativeQuery = true)
	public List<Paciente> findPacientesActivos();
}
