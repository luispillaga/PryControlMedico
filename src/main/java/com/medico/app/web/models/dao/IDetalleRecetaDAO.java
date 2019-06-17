package com.medico.app.web.models.dao;

import com.medico.app.web.models.entities.DetalleReceta;
import org.springframework.data.repository.CrudRepository;

public interface IDetalleRecetaDAO extends CrudRepository<DetalleReceta, Integer> {
}
