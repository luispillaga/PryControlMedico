package com.medico.app.web.models.service;

import com.medico.app.web.models.entities.ViaAdministracion;

import java.util.List;

public interface IViaAdministracionService {
    public ViaAdministracion findById(Integer id);

    public List<ViaAdministracion> findAll();
}
