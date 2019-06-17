package com.medico.app.web.models.dao;

import com.medico.app.web.models.entities.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface IPacienteDAO extends CrudRepository<Paciente, Integer> {
}
