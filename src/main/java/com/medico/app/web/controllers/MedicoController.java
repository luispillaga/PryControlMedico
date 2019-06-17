package com.medico.app.web.controllers;

import com.medico.app.web.models.entities.Medico;
import com.medico.app.web.models.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/medico")
@SessionAttributes({"medico", "title"})
public class MedicoController {

    @Autowired
    private IMedicoService service;

    @GetMapping(value = "/create")
    public String create(Model model){
        Medico medico =  new Medico();
        model.addAttribute("medico", medico);
        model.addAttribute("title", "Registro de Médico");
        return "medico/form";
    }

    @PostMapping(value = "/save")
    public String save(@Valid Medico medico, BindingResult result, Model model, RedirectAttributes message, SessionStatus session){
        try {
            if (result.hasErrors()){
                return "medico/form";
            }
            String msg = medico.getIdPersona() == null ? medico.getNombre() + " " + medico.getApellido() + " ha sido agregado a la lista de medicos." : medico.getNombre() + " " + medico.getApellido() + " ha sido actualizado.";
            service.save(medico);
            session.setComplete();
            message.addFlashAttribute("success", msg);
        }catch (Exception ex){
            model.addAttribute("error", ex.toString());
        }
        return "redirect:/medico/list";
    }

    @GetMapping(value = "/retrive/{id}")
    public String retrive(@PathVariable(value = "id")Integer id, Model model){
        Medico medico = service.findById(id);
        model.addAttribute("medico", medico);
        return "medico/card";
    }

    @GetMapping(value = "/update/{id}")
    public String update(@PathVariable(value = "id")Integer id, Model model){
        Medico medico = service.findById(id);
        model.addAttribute("medico", medico);
        model.addAttribute("title", "Registro de Médico");
        return "medico/form";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id")Integer id, Model model, RedirectAttributes message){
        try{
            service.delete(id);
            message.addFlashAttribute("success", "Medico eliminado correctamente");
        }catch (Exception ex){
            model.addAttribute("error", ex.toString());
        }
        return "redirect:/medico/list";
    }

    @GetMapping(value = "/list")
    public String list(Model model){
        List<Medico> medicos = service.findAll();
        model.addAttribute("medicos", medicos);
        model.addAttribute("title", "Lista de médicos");
        return "medico/list";
    }


}
