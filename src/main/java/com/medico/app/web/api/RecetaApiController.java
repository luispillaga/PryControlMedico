package com.medico.app.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.medico.app.web.models.entities.Receta;
import com.medico.app.web.models.services.IRecetaService;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class RecetaApiController {

	
	 @Autowired
	    private IRecetaService service;

	    @GetMapping("/receta")
	    public List<Receta> list() {
	        return service.findAll();
	    }

	    @GetMapping("/receta/{id}")
	    public Receta retrieve(@PathVariable Integer id) {
	        return service.findById(id);
	    }
}
