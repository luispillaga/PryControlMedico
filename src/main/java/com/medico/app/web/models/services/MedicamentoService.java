package com.medico.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medico.app.web.models.dao.IMedicamentoDAO;
import com.medico.app.web.models.entities.Medicamento;

@Service
public class MedicamentoService implements IMedicamentoService {

	@Autowired
	private IMedicamentoDAO dao;
	
	@Override
	@Transactional
	public Medicamento save(Medicamento medicamento) {		
		dao.save(medicamento);
		return medicamento; 
	}

	@Override
	@Transactional(readOnly=true)
	public Medicamento findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {		
		dao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Medicamento> findByNombre(String criteria) {		
		return dao.findByNombre(criteria.toLowerCase());
	}

	@Override
	@Transactional(readOnly=true)
	public List<Medicamento> findByComponenteActivoLike(String criteria) {		
		return dao.findByComponenteActivo(criteria);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Medicamento> findByAll() {
		return (List<Medicamento>) dao.findAll();
	}

	@Override
	public List<Medicamento> findMedicamentos(Integer id) {
		return (List<Medicamento>) dao.findMedicamentos(id);
  }
  
  @Override
  @Transactional(readOnly=true)
	public List<Medicamento> listMedicamentoByPaciente(String criteria) {
		// TODO Auto-generated method stub
		return dao.listMedicamentoByPaciente(criteria);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Medicamento> findByPaciente(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
