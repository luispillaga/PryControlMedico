package com.medico.app.web.models.services;

import java.util.List;

import com.medico.app.web.models.entities.Medicamento;

public interface IMedicamentoService {
	
	public Medicamento save(Medicamento medicamento);
	
	public Medicamento findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Medicamento> findByAll();
	
	public List<Medicamento> findByNombre(String criteria);
	
	public List<Medicamento> findByComponenteActivoLike(String criteria);
	
	public List<Medicamento> findMedicamentos(Integer id);

  	public List<Medicamento> listMedicamentoByPaciente(String criteria);
	
	public List<Medicamento> findByPaciente(String criteria);
}
