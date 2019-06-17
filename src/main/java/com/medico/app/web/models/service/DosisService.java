package com.medico.app.web.models.service;


import com.medico.app.web.models.dao.IDosisDAO;
import com.medico.app.web.models.entities.Dosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DosisService implements IDosisService{

    @Autowired
    private IDosisDAO dao;

    @Override
    public void save(Dosis dosis) {
        dao.save(dosis);
    }

    @Override
    public Dosis findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Dosis> findAll() {
        return (List<Dosis>) dao.findAll();
    }
}
