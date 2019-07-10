package com.medico.app.web.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.medico.app.web.models.entities.DetalleReceta;
import com.medico.app.web.models.entities.Dosis;
import com.medico.app.web.models.entities.Paciente;
import com.medico.app.web.models.entities.Receta;
import com.medico.app.web.models.services.IDetalleRecetaService;
import com.medico.app.web.models.services.IDosisService;
import com.medico.app.web.models.services.IPacienteService;
import com.medico.app.web.models.services.IRecetaService;

@RestController
@RequestMapping(value="/api")
public class DosisApiController {
	@Autowired
    private IDosisService service;

    @Autowired
    private IPacienteService srvPaciente;

    @Autowired
    private IRecetaService srvReceta;

    @Autowired
    private IDetalleRecetaService srvDetalleReceta;

   

    @GetMapping(value="/dosis/{id}" )
    public Dosis retrieve(@PathVariable(value = "id") Integer id){
    	return service.findById(id);
    }

    @GetMapping(value="/dosis" )
    public List<Dosis> list(){
        return service.findAll();
    }
    
    @GetMapping(value="/dosisxdetalle/{id}" )
    public List<Dosis> findAllOfOneDetail(@PathVariable(value = "id") Integer id){
    	return service.findAllOfOneDetail(id);
    }
}
