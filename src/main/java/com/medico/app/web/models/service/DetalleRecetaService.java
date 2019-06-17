package com.medico.app.web.models.service;

import com.medico.app.web.models.dao.IDetalleRecetaDAO;
import com.medico.app.web.models.entities.DetalleReceta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleRecetaService implements IDetalleRecetaService {

    @Autowired
    private IDetalleRecetaDAO dao;

    @Override
    public void save(DetalleReceta detalleReceta) {
        dao.save(detalleReceta);
    }

    @Override
    public DetalleReceta findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<DetalleReceta> findAll() {
        return (List<DetalleReceta>) dao.findAll();
    }
}
