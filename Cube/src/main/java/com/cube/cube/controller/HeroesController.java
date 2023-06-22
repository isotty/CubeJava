package com.cube.cube.controller;

import com.cube.cube.domain.Heroes;
import com.cube.cube.services.HeroesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Heroes")
public class HeroesController {
    private final HeroesService heroesService;

    public HeroesController(HeroesService heroesService){
        this.heroesService = heroesService;
    }

    @GetMapping
    public String getHeroes(Model model){
        model.addAttribute("heroesList",heroesService.findAll());
        return "Heroes";
    }


    @GetMapping("/create")
    public String createHeroes(Model model) {
        model.addAttribute("heroesList", new Heroes());
        return "createHeroes";
    }

    @PostMapping("/create")
    public String createHeroes(@Validated Heroes heroes, BindingResult result) {
        if (result.hasErrors()) {
            return "createHeroes";
        }
        heroesService.save(heroes);
        return "redirect:/Heroes";
    }
    @GetMapping("/edit/{id}")
    public String editHeroesForm(@PathVariable("id") Long id, Model model) {
        Heroes heroesFound = heroesService.findById(id);

        if (heroesFound != null) {
            model.addAttribute("heroesList", heroesFound);
            return "editHeroes";
        } else {
            return "redirect:/Heroes";
        }
    }

    @PostMapping("/edit/{id}")
    public String editHeroes(@PathVariable("id") Long id, @Validated Heroes heroes, BindingResult result) {
        if (result.hasErrors()) {
            return "editHeroes";
        }
        heroes.setId(id);
        heroesService.save(heroes);
        return "redirect:/Heroes";
    }

    @GetMapping("/delete/{id}")
    public String deleteHeroes(@PathVariable("id") Long id) {
        heroesService.deleteById(id);
        return "redirect:/Heroes";
    }
}