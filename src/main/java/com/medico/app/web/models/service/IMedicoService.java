package com.medico.app.web.models.service;

import com.medico.app.web.models.entities.Medico;

import java.util.List;

public interface IMedicoService  {
    public void save(Medico medico);
    public Medico findById(Integer id);
    public void delete(Integer id);
    public List<Medico> findAll();
}
