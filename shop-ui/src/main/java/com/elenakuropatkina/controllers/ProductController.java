package com.elenakuropatkina.controllers;

import com.elenakuropatkina.controllers.represent.ProductRepresent;
import com.elenakuropatkina.exeptions.NotFoundException;
import com.elenakuropatkina.repositories.BrandRepository;
import com.elenakuropatkina.repositories.CategoryRepository;
import com.elenakuropatkina.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class ProductController {

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;


    private final ProductService productService;

    @Autowired
    public ProductController(BrandRepository brandRepository, CategoryRepository categoryRepository,
                             ProductService productService) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    @GetMapping("/products")
    public String productsPage(Model model) {
        model.addAttribute("activePage", "Products");
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/product/{id}/edit")
    public String editProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Products");
        model.addAttribute("product", productService.findById(id).orElseThrow(() -> new NotFoundException()));
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "product_form";
    }

    @GetMapping("/product/create")
    public String createProduct(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Products");
        model.addAttribute("product", new ProductRepresent());
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "product_form";
    }

    @PostMapping("/product")
    public String upsertProduct(@Valid ProductRepresent product, Model model, BindingResult bindingResult) throws IOException {
        model.addAttribute("activePage", "Products");

        if (bindingResult.hasErrors()) {
            return "product_form";
        }

        productService.save(product);
        return "redirect:/products";
    }

    @DeleteMapping("/product/{id}/delete")
    public String deleteProduct(Model model, @PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/products";
    }
}


