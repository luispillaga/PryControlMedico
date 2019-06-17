package com.medico.app.web.models.service;

import com.medico.app.web.models.dao.IPacienteDAO;
import com.medico.app.web.models.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteDAO dao;

    @Override
    public void save(Paciente paciente) {
        dao.save(paciente);
    }

    @Override
    public Paciente findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Paciente> findAll()     {
        return (List<Paciente>) dao.findAll();
    }
}
