package com.medico.app.web.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.medico.app.web.models.entities.Medicamento;

public interface IMedicamentoDAO extends CrudRepository<Medicamento, Integer> {

	@Query("SELECT M FROM Medicamento M WHERE LOWER(M.nombreComercial) LIKE CONCAT('%',?1,'%')")
	public List<Medicamento> findByNombre(String criteria);
	
	public List<Medicamento> findByComponenteActivo(String criteria);
	
	//consulta completa 
	//SELECT receta.idreceta, detallereceta.iddetallereceta, detallereceta.idmedicamento, medicamento.nombrecomercial  FROM receta,paciente,detallereceta,medicamento WHERE receta.idpaciente=paciente.idpersona AND detallereceta.idreceta=receta.idreceta AND medicamento.idmedicamento=detallereceta.idmedicamento AND receta.activo=true AND receta.idreceta=1
	//aqui solo obtengo los medicamentos
	@Query(value = "SELECT * FROM receta,paciente,detallereceta,medicamento WHERE receta.idpaciente=paciente.idpersona AND detallereceta.idreceta=receta.idreceta AND medicamento.idmedicamento=detallereceta.idmedicamento AND receta.activo=true AND receta.idpaciente=?1", nativeQuery = true)
	public List<Medicamento> findMedicamentos(Integer id);
	
}
