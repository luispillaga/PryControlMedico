package com.medico.app.web.models.services;

import java.util.List;

import com.medico.app.web.models.entities.Dosis;

public interface IDosisService {

	public Dosis save(Dosis dosis);

	public void delete(Integer id);
	
	public Dosis findById(Integer id);
	
	public List<Dosis> findAll();

	public List<Dosis> findNotTakenPills(Integer idDetalleReceta);
	
	public List<Dosis> findAllOfOneDetail(Integer idDetalleReceta);
}
