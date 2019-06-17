package com.medico.app.web.models.service;

import com.medico.app.web.models.entities.Receta;

import java.util.List;

public interface IRecetaService {

    public void save(Receta receta);

    public Receta findById(Integer id);

    public void delete(Integer id);

    public List<Receta> findAll();
}
