package com.elenakuropatkina.controllers;

import com.elenakuropatkina.models.Author;
import com.elenakuropatkina.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class BrandController {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;

    }

    @GetMapping("/brands")
    public String brandsPage(Model model) {
        model.addAttribute("activePage", "Brands");
        model.addAttribute("brands", brandRepository.findAll());
        return "brands";
    }

    @GetMapping("/brand/{id}/edit")
    public String EditBrand(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Brands");
        model.addAttribute("brand", brandRepository.findById(id).orElseThrow(IllegalStateException::new));
        return "brand_form";
    }

    @GetMapping("/brand/create")
    public String createBrand(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Brands");
        model.addAttribute("brand", new Author());
        return "brand_form";
    }

    @DeleteMapping("/brand/{id}/delete")
    public String deleteBrand(Model model, @PathVariable("id") Long id) {
        brandRepository.deleteById(id);
        return "redirect:/brands";
    }

    @PostMapping("/brand")
    public String upsertBrand(Model model, RedirectAttributes redirectAttributes, Author author) {
        model.addAttribute("activePage", "Brands");

        try {
            brandRepository.save(author);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (author.getId() == null) {
                return "redirect:/brand/create";
            }
            return "redirect:/brand/" + author.getId() + "/edit";
        }
        return "redirect:/brands";
    }

}