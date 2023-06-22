package com.cube.cube.controller;

import com.cube.cube.domain.Sos;
import com.cube.cube.services.SosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Sos")
public class SosController {
    private final SosService sosService;

    public SosController (SosService sosService){
        this.sosService = sosService;
    }

    @GetMapping
    public String getSos(Model model){
        model.addAttribute("sosList",sosService.findAll());
        return "Sos";
    }


    @GetMapping("/create")
    public String createSos(Model model) {
        model.addAttribute("sosList", new Sos());
        return "createSos";
    }

    @PostMapping("/create")
    public String createSos(@Validated Sos sos, BindingResult result) {
        if (result.hasErrors()) {
            return "createSos";
        }
        sosService.save(sos);
        return "redirect:/Sos";
    }
    @GetMapping("/edit/{id}")
    public String editSosForm(@PathVariable("id") Long id, Model model) {
        Sos sosFound = sosService.findById(id);

        if (sosFound != null) {
            model.addAttribute("sosList", sosFound);
            return "editSos";
        } else {
            return "redirect:/Sos";
        }
    }

    @PostMapping("/edit/{id}")
    public String editSos(@PathVariable("id") Long id, @Validated Sos sos, BindingResult result) {
        if (result.hasErrors()) {
            return "editSos";
        }
        sos.setId(id);
        sosService.save(sos);
        return "redirect:/Sos";
    }

    @GetMapping("/delete/{id}")
    public String deleteSos(@PathVariable("id") Long id) {
        sosService.deleteById(id);
        return "redirect:/Sos";
    }
}
