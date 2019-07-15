package com.medico.app.web.models.services;


import java.util.List;

import com.medico.app.web.models.entities.DetalleReceta;

public interface IDetalleRecetaService {

	public void save(DetalleReceta detalleReceta);
	
	public DetalleReceta findById(Integer id);
	
	public void delete(Integer id);
	
	public List<DetalleReceta> findAll();

	public List<DetalleReceta> findNotTakenDetalles(Integer idReceta);

	public void setDetalleRecetaInactiveStatus(Integer id);
	
	public List<DetalleReceta> findAllOfOneRecipe(Integer idReceta);
}
