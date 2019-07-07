package com.medico.app.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.app.web.models.entities.Medico;
import com.medico.app.web.models.entities.Paciente;
import com.medico.app.web.models.services.IMedicoService;

@RestController
@RequestMapping(value="/api")
public class MedicoApiController {
    @Autowired
    private IMedicoService service;

    @GetMapping("/medico")
    public List<Medico> list() {
        return service.findAll();
    }
    
    @GetMapping("/medi-medicamento/{id}")
    public List<Paciente> medicamentosByPaciente(@PathVariable Integer id) {
        //return service.findallmedicamentobypaciente();
    	return null;
    }

    @GetMapping("/medico/{id}")
    public Medico retrieve(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("/medico")
    public Medico save(@RequestBody Medico medico) {
        return service.save(medico);
    }

    @DeleteMapping("/medico/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        service.delete(id);
    }
    @PutMapping("/medico/{id}")
    public Medico update(@RequestBody Medico medico, @PathVariable Integer id) {
        Medico medico1 = service.findById(id);
        if (medico1 != null){
        	medico1.setNombre(medico.getNombre());
        	medico1.setApellido(medico.getApellido());
        	medico1.setCedula(medico.getCedula());
            medico1.setTelefono(medico.getTelefono());
            medico1.setEmail(medico.getEmail());
            medico1.setNacimiento(medico.getNacimiento());
            medico1.setLicencia(medico.getLicencia());
            medico1.setEspecialidad(medico.getEspecialidad());
            return service.save(medico1);
        }else
            return service.save(medico);
    }
}
