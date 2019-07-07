package com.medico.app.web.api;

import java.util.ArrayList;
import java.util.List;

import com.medico.app.web.models.entities.Medicamento;
import com.medico.app.web.models.entities.Medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.app.web.models.entities.Medicamento;
import com.medico.app.web.models.services.IMedicamentoService;

@RestController
@RequestMapping(value="/api")
public class MedicamentoApiController {
	 @Autowired
	    private IMedicamentoService service;

	    @GetMapping("/medicamentoxpaciente/{id}")
	    public List<Medicamento> listMedicamentoByPaciente(@PathVariable String id) {
	        return service.listMedicamentoByPaciente(id);
	    }
	   
	    @GetMapping(value = "/find/{criteria}", produces = { "application/json" })
		public @ResponseBody List<Medicamento> findByNombre(@PathVariable String criteria) {
			return service.listMedicamentoByPaciente(criteria);
		}
	    
	 private IMedicamentoService service;
	 
	 @GetMapping("/medicamento")
	 public List<Medicamento> list() {
		 return service.findByAll();
	 }
	 
	 @GetMapping("/medicamento/{id}")
	 public Medicamento retrieve(@PathVariable Integer id) {
		 return service.findById(id);
	 }
	 
	 @PostMapping("/medicamento")
	 public Medicamento save(@RequestBody Medicamento medicamento) {
		 return service.save(medicamento);
	 }
	 
	 @DeleteMapping("/medicamento/{id}")
	 public void deleteEmployee(@PathVariable Integer id) {
		 service.delete(id);
	 }
	 
	 @PutMapping("/medicamento/{id}")
	 public Medicamento update(@RequestBody Medicamento medicamento, @PathVariable Integer id) {
		 Medicamento newMedicamento = service.findById(id);
		 if (newMedicamento != null){
			 newMedicamento.setComponenteActivo(medicamento.getComponenteActivo());
			 newMedicamento.setConcentracion(medicamento.getConcentracion());
			 newMedicamento.setNombreComercial(medicamento.getNombreComercial());
			 newMedicamento.setPrecio(medicamento.getPrecio());
			 newMedicamento.setFechaCaducidad(medicamento.getFechaCaducidad());
			 newMedicamento.setViaAdministracion(medicamento.getViaAdministracion());
			 return service.save(newMedicamento);
		 }else
			 return service.save(newMedicamento);
	    }
	 
	 @GetMapping("/medicamentoxpaciente/{id}")
	    public List<Medicamento> recetasActivas(@PathVariable Integer id){
	    	return service.findMedicamentos(id);
	    }
	 
}
