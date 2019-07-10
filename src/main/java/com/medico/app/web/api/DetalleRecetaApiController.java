package com.medico.app.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.app.web.models.entities.DetalleReceta;
import com.medico.app.web.models.entities.Receta;
import com.medico.app.web.models.services.IDetalleRecetaService;
import com.medico.app.web.models.services.IRecetaService;

@RestController
@RequestMapping(value="/api")
public class DetalleRecetaApiController {

	    @Autowired
	    private IDetalleRecetaService service;

	    @GetMapping("/detallereceta")
	    public List<DetalleReceta> list() {
	        return service.findAll();
	    }

	    @GetMapping("/detallereceta/{id}")
	    public DetalleReceta retrieve(@PathVariable Integer id) {
	        return service.findById(id);
	    }
  
      @GetMapping(value="/detallexreceta/{id}" )
      public List<DetalleReceta> findAllOfOneRecipe(@PathVariable(value = "id") Integer id){
        return service.findAllOfOneRecipe(id);
      }
}
