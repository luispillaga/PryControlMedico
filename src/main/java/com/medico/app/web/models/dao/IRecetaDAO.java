package com.medico.app.web.models.dao;

import com.medico.app.web.models.entities.Receta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRecetaDAO extends CrudRepository<Receta, Integer> {


}