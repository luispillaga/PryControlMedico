package com.medico.app.web.models.dao;

import com.medico.app.web.models.entities.Medico;
import org.springframework.data.repository.CrudRepository;

public interface IMedicoDAO  extends CrudRepository<Medico, Integer> {

}
