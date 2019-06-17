package com.medico.app.web.controllers;

import com.medico.app.web.models.entities.Medico;
import com.medico.app.web.models.entities.Paciente;
import com.medico.app.web.models.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/paciente")
@SessionAttributes({"paciente", "title", "tiposSangre"})
public class PacienteController {

    @Autowired
    private IPacienteService service;

    @GetMapping(value = "/create")
    public String create(Model model){
        Paciente paciente = new Paciente();
        model.addAttribute("paciente", paciente);
        model.addAttribute("title", "Registro de Paciente");
        model.addAttribute("tiposSangre", this.getBloodTypeList());
        return "paciente/form";
    }

    @PostMapping(value = "/save")
    public String save(@Valid Paciente paciente, BindingResult result, Model model,
                       RedirectAttributes message, SessionStatus session){
        try {
            if (result.hasErrors()){
                return "paciente/form";
            }
            String msg = paciente.getIdPersona() == null ? paciente.getNombre() + " " + paciente.getApellido() + " ha sido agregado a la lista de pacientes." : paciente.getNombre() + " " + paciente.getApellido() + " ha sido actualizado.";
            service.save(paciente);
            session.setComplete();
            message.addFlashAttribute("success", msg);
        }catch (Exception ex){
            message.addFlashAttribute("error", ex.toString());
        }
        return "redirect:/paciente/list";
    }

    @GetMapping(value = "/retrive/{id}")
    public String retrive(@PathVariable(value = "id")Integer id, Model model){
        Paciente paciente = service.findById(id);
        model.addAttribute("paciente", paciente);
        return "paciente/card";
    }

    @GetMapping(value = "/update/{id}")
    public String update(@PathVariable(value = "id")Integer id, Model model){
        Paciente paciente = service.findById(id);
        model.addAttribute("paciente", paciente);
        model.addAttribute("title", "Registro de Paciente");
        model.addAttribute("tiposSangre", this.getBloodTypeList());
        return "paciente/form";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id")Integer id, Model model, RedirectAttributes message){
        try{
            service.delete(id);
            message.addFlashAttribute("success", "Paciente eliminado correctamente");
        }catch (Exception ex){
            model.addAttribute("error", ex.toString());
        }
        return "redirect:/paciente/list";
    }

    @GetMapping(value = "/list")
    public String list(Model model){
        List<Paciente> pacientes = service.findAll();
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("title", "Listado de pacientes");
        return "paciente/list";
    }

    @ModelAttribute("tipoSangre")
    public ArrayList<String> getBloodTypeList() {
        ArrayList<String> bloodType = new ArrayList<String>();
        bloodType.add("O+");
        bloodType.add("O-");
        bloodType.add("A-");
        bloodType.add("A+");
        bloodType.add("B-");
        bloodType.add("B+");
        bloodType.add("AB-");
        bloodType.add("AB+");
        return bloodType;
    }
}
