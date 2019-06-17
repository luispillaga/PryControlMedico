package com.medico.app.web.models.service;

import com.medico.app.web.models.entities.Dosis;

import java.util.List;

public interface IDosisService {
    public void save(Dosis dosis);
    public Dosis findById(Integer id);
    public void delete(Integer id);
    public List<Dosis> findAll();
}
