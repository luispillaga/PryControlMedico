package com.medico.app.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medico.app.web.models.entities.Medicamento;
import com.medico.app.web.models.entities.Medico;
import com.medico.app.web.models.services.IMedicamentoService;

@RestController
@RequestMapping(value="/api")
public class MedicamentoApiController {
	 @Autowired
	    private IMedicamentoService service;

	    @GetMapping("/medicamento")
	    public List<Medicamento> list() {
	        return service.findByAll();
	    }
	    @GetMapping("/medicamentoxpaciente/{id}")
	    public List<Medicamento> listMedicamentoByPaciente(@PathVariable String id) {
	        return service.listMedicamentoByPaciente(id);
	    }
	   
	    @GetMapping(value = "/find/{criteria}", produces = { "application/json" })
		public @ResponseBody List<Medicamento> findByNombre(@PathVariable String criteria) {
			return service.listMedicamentoByPaciente(criteria);
		}
	    
}
