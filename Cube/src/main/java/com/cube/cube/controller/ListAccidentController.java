package com.cube.cube.controller;

import com.cube.cube.domain.ListAccidentType;
import com.cube.cube.services.ListAccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/listAccident")
public class ListAccidentController {
    private final ListAccidentService listAccidentService;

    public ListAccidentController (ListAccidentService listAccidentService){
        this.listAccidentService = listAccidentService;
    }

    @GetMapping
    public String getListAccident(Model model){
        model.addAttribute("listAccidentTypeList",listAccidentService.findAll());
        return "listAccident";
    }


    @GetMapping("/create")
    public String createListAccident(Model model) {
        model.addAttribute("listAccidentTypeList", new ListAccidentType());
        return "createlistAccident";
    }

    @PostMapping("/create")
    public String createListAccident(@Validated  ListAccidentType listAccidentType, BindingResult result) {
        if (result.hasErrors()) {
            return "createlistAccident";
        }
        listAccidentService.save(listAccidentType);
        return "redirect:/listAccident";
    }
    @GetMapping("/edit/{id}")
    public String editListAccidentForm(@PathVariable("id") Long id, Model model) {
        ListAccidentType listAccidentTypeFound = listAccidentService.findById(id);

        if (listAccidentTypeFound != null) {
            model.addAttribute("listAccidentTypeList", listAccidentTypeFound);
            return "editlistAccident";
        } else {
            return "redirect:/listAccident";
        }
    }

    @PostMapping("/edit/{id}")
    public String editListAccident(@PathVariable("id") Long id, @Validated ListAccidentType listAccidentType, BindingResult result) {
        if (result.hasErrors()) {
            return "editlistAccident";
        }
        listAccidentType.setId(id);
        listAccidentService.save(listAccidentType);
        return "redirect:/listAccident";
    }

    @GetMapping("/delete/{id}")
    public String deletelistAccident(@PathVariable("id") Long id) {
        listAccidentService.deleteById(id);
        return "redirect:/listAccident";
    }
}
