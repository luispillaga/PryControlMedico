package com.medico.app.web.models.service;

import com.medico.app.web.models.entities.Medicamento;

import java.util.List;

public interface IMedicamentoService {
    public void save(Medicamento medicamento);
    public Medicamento findById(Integer id);
    public void delete(Integer id);
    public List<Medicamento> findAll();
    public List<Medicamento> findByNombre(String criteria);
    public List<Medicamento> findByComponenteActivoLike(String criteria);
}
