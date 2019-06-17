package com.medico.app.web.controllers;

import com.medico.app.web.models.entities.Medicamento;
import com.medico.app.web.models.entities.ViaAdministracion;
import com.medico.app.web.models.service.IMedicamentoService;
import com.medico.app.web.models.service.IViaAdministracionService;
import javafx.beans.binding.Binding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/medicamento")
@SessionAttributes({"medicamento", "title", "vias"})
public class MedicamentoController {

    @Autowired
    private IMedicamentoService service;

    @Autowired
    private IViaAdministracionService srvViaAdministacion;

    @GetMapping(value = "/create")
    public String create(Model model){
        List<ViaAdministracion> vias = srvViaAdministacion.findAll();
        Medicamento medicamento = new Medicamento();
        model.addAttribute("medicamento", medicamento);
        model.addAttribute("title", "Registro de Medicamento");
        model.addAttribute("vias", vias);
        return "medicamento/form";
    }

    @PostMapping(value = "/save")
    public String save(@Valid Medicamento medicamento, BindingResult result, Model model, RedirectAttributes message, SessionStatus session){
        try {
            if(result.hasErrors()){
                return "medicamento/form";
            }
            String msg = medicamento.getIdMedicamento() == null ? medicamento.getNombreComercial() + " ha sido agregado a la lista de medicamentos." : medicamento.getNombreComercial() + " ha sido actualizado.";
            service.save(medicamento);
            session.setComplete();
            message.addFlashAttribute("success", msg);
        }catch (Exception ex){
            message.addFlashAttribute("error", ex.toString());
        }
        return "redirect:/medicamento/list";
    }

    @GetMapping(value = "/retrive/{id}")
    public String retrive(@PathVariable(value = "id")Integer id, Model model){
        Medicamento medicamento = service.findById(id);
        model.addAttribute("medicamento", medicamento);
        return "medicamento/card";
    }

    @GetMapping(value = "/update/{id}")
    public String update(@PathVariable(value = "id")Integer id, Model model){
        Medicamento medicamento = service.findById(id);
        model.addAttribute("medicamento", medicamento);
        model.addAttribute("title","Actualización de medicamento: " + medicamento.getNombreComercial());
        List<ViaAdministracion> vias = srvViaAdministacion.findAll();
        model.addAttribute("vias",vias);
        return "medicamento/form";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id")Integer id, Model model, RedirectAttributes message){
        try{
            service.delete(id);
            message.addFlashAttribute("success", "Medicamento eliminado correctamente");

        }catch (Exception ex){
            model.addAttribute("error", ex.toString());
        }
        return "redirect:/medicamento/list";
    }

    @GetMapping(value = "/list")
    public String list(Model model){
        List<Medicamento> medicamentos = service.findAll();
        model.addAttribute("medicamentos", medicamentos);
        model.addAttribute("title", "Listado de medicamentos");
        return "medicamento/list";
    }

    @GetMapping(value = "/find/{criteria}", produces = { "application/json" })
    public @ResponseBody List<Medicamento> findByNombre(@PathVariable String criteria) {
        List<Medicamento> medicamentosNC = service.findByNombre(criteria);
        List<Medicamento> medicamentosCA = service.findByComponenteActivoLike(criteria);
        List<Medicamento> result = new ArrayList<>();
        result.addAll(medicamentosCA);
        result.addAll(medicamentosNC);
        return result;
    }
}
