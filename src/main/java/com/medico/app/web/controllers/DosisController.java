package com.medico.app.web.controllers;

import com.medico.app.web.models.entities.Dosis;
import com.medico.app.web.models.entities.Medico;
import com.medico.app.web.models.service.IDosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/dosis")
public class DosisController {

    @Autowired
    private IDosisService service;

    @GetMapping(value="/create" )
    public String create(Model model){
        Dosis dosis=new Dosis();
        model.addAttribute("dosis",dosis);
        return "dosis/form";
    }

    @GetMapping(value = "/retrive/{id}")
    public String retrive(@PathVariable(value = "id")Integer id, Model model){
        Dosis dosis = service.findById(id);
        model.addAttribute("dosis", dosis);
        return "dosis/card";
    }


    @GetMapping(value = "/update/{id}")
    public String update(@PathVariable(value = "id")Integer id, Model model){
        Dosis dosis = service.findById(id);
        model.addAttribute("dosis", dosis);
        return "dosis/form";
    }

    @PostMapping(value = "/save")
    public String save(Dosis dosis, Model model){
        try {
            service.save(dosis);
        }catch (Exception ex){
            model.addAttribute("error", ex.toString());
        }
        return "redirect:/dosis/list";
    }

    @GetMapping(value="/delete" )
    public String delete(@PathVariable(value = "id") Integer id,
                         Model model){
        try{
            service.delete(id);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }
        return "redirect:/dosis/list";
    }

    @GetMapping(value = "/list")
    public String list(Model model){
        List<Dosis> listaDosis = service.findAll();
        model.addAttribute("listaDosis", listaDosis);
        return "dosis/list";
    }

}
