package com.medico.app.web.models.service;


import com.medico.app.web.models.entities.Paciente;

import java.util.List;

public interface IPacienteService {
    public void save(Paciente paciente);
    public Paciente findById(Integer id);
    public void delete(Integer id);
    public List<Paciente> findAll();
}
