package com.medico.app.web.models.service;

import com.medico.app.web.models.dao.IViaAdministracionDAO;
import com.medico.app.web.models.entities.ViaAdministracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaAdministracionService implements IViaAdministracionService {

    @Autowired
    private IViaAdministracionDAO dao;


    @Override
    public ViaAdministracion findById(Integer id) {
        // TODO Auto-generated method stub
        return dao.findById(id).get();
    }

    @Override
    public List<ViaAdministracion> findAll() {
        // TODO Auto-generated method stub
        return (List<ViaAdministracion>) dao.findAll();
    }

}