package com.medico.app.web.models.service;


import com.medico.app.web.models.entities.DetalleReceta;

import java.util.List;

public interface IDetalleRecetaService {
    public void save(DetalleReceta detalleReceta);
    public DetalleReceta findById(Integer id);
    public void delete(Integer id);
    public List<DetalleReceta> findAll();
}
