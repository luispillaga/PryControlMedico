package com.medico.app.web.controllers;

import com.medico.app.web.models.dao.IRecetaDAO;
import com.medico.app.web.models.entities.*;
import com.medico.app.web.models.service.IMedicamentoService;
import com.medico.app.web.models.service.IMedicoService;
import com.medico.app.web.models.service.IPacienteService;
import com.medico.app.web.models.service.IRecetaService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
@RequestMapping(value = "/receta")
@SessionAttributes({"receta","title"})
public class RecetaController {

    //Servicio ==>Inyeccion de dependencias hacer una instancia del servicio

    @Autowired
    private IRecetaService service;

    @Autowired
    private IMedicoService srvMedico;

    @Autowired
    private IPacienteService srvPaciente;

    @Autowired
    private IMedicamentoService srvMedicamento;

    @GetMapping(value = "/create")
    public String create(Model model){
        Receta receta = new Receta();
        model.addAttribute("title","Registro de nueva receta");
        model.addAttribute("receta", receta);
        List<Paciente> pacientes = srvPaciente.findAll();
        List<Medico> medicos = srvMedico.findAll();
        model.addAttribute("pacientes",pacientes);
        model.addAttribute("medicos",medicos);
        return "receta/form";
    }

    @PostMapping(value = "/save")
    public String save(@Valid Receta receta, BindingResult result,
                       Model model, RedirectAttributes message,
                       SessionStatus session){
        try{
            if(result.hasErrors()) {
                return "receta/form";
            }
            String msg = receta.getIdReceta() == null ? "La receta ha sido creada." : "La receta ha sido actualizada.";
            service.save(receta);
            session.setComplete();
            message.addFlashAttribute("success", msg);
        }catch (Exception ex){
            message.addFlashAttribute("error", ex.toString());
        }
        return "redirect:/receta/list";
    }

    @GetMapping(value = "/retrive/{id}")
    public String retrive(@PathVariable(value = "id")Integer id, Model model){
        Receta receta = service.findById(id);
        model.addAttribute("receta", receta);
        return "receta/card";
    }

    @GetMapping(value = "/update/{id}")
    public String update(@PathVariable(value = "id")Integer id, Model model){
        Receta receta = service.findById(id);
        model.addAttribute("receta", receta);
        return "receta/form";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id")Integer id, Model model){
        try {
            service.delete(id);
        }
        catch(Exception ex){
        }
        return "redirect:/receta/list";
    }

    @GetMapping(value = "/list")
    public String list(Model model){
        List<Receta> recetas = service.findAll();
        model.addAttribute("title","Lista de Recetas");
        model.addAttribute("recetas", recetas);
        return "receta/list";
    }

    @PostMapping(value="/addDetail", produces="application/json")
    public @ResponseBody List<DetalleReceta> addDetalleReceta(
            @RequestBody DetalleReceta detail, @SessionAttribute(name="receta") Receta receta) {
        if(receta.getDetalles() == null)
        {
            List<DetalleReceta> detalles = new ArrayList<>();
            receta.setDetalles(detalles);
        }
        Medicamento medicamento = srvMedicamento.findById(detail.getMedicamentoId());
        detail.setMedicamento(medicamento);
        receta.getDetalles().add(detail);
        return receta.getDetalles();
    }

}
