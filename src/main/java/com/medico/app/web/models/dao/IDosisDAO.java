package com.medico.app.web.models.dao;

import com.medico.app.web.models.entities.Dosis;
import org.springframework.data.repository.CrudRepository;

public interface IDosisDAO extends CrudRepository<Dosis, Integer> {
}
