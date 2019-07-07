package com.medico.app.web.api;

import com.medico.app.web.models.entities.Paciente;
import com.medico.app.web.models.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class PacienteApiController {

    @Autowired
    private IPacienteService service;

    @GetMapping("/paciente")
    public List<Paciente> list() {
        return service.findAll();
    }
    
    @GetMapping("/paciente-medicamento/{id}")
    public List<Paciente> medicamentosByPaciente(@PathVariable Integer id) {
        //return service.findallmedicamentobypaciente();
    	return null;
    }

    @GetMapping("/paciente/{id}")
    public Paciente retrieve(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("/paciente")
    public Paciente save(@RequestBody Paciente paciente) {
        return service.save(paciente);
    }

    @DeleteMapping("/paciente/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        service.delete(id);
    }
    @PutMapping("/paciente/{id}")
    public Paciente update(@RequestBody Paciente paciente, @PathVariable Integer id) {
        Paciente paciente1 = service.findById(id);
        if (paciente1 != null){
            paciente1.setNombre(paciente.getNombre());
            paciente1.setApellido(paciente.getApellido());
            paciente1.setCedula(paciente.getCedula());
            paciente1.setTelefono(paciente.getTelefono());
            paciente1.setEmail(paciente.getEmail());
            paciente1.setNacimiento(paciente.getNacimiento());
            paciente1.setAlergias(paciente.getAlergias());
            paciente1.setAntecedentes(paciente.getAntecedentes());
            paciente1.setTipoSangre(paciente.getTipoSangre());
            return service.save(paciente1);
        }else
            return service.save(paciente);
    }



}
