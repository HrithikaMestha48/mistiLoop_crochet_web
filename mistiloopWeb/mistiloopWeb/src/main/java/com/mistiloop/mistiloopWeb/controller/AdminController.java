package com.mistiloop.mistiloopWeb.controller;

import com.mistiloop.mistiloopWeb.entity.Product;
import com.mistiloop.mistiloopWeb.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductRepository productRepository;

    public AdminController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Open Admin Dashboard
    @GetMapping
    public String adminPage(Model model) {

        model.addAttribute(
                "products",
                productRepository.findAll()
        );

        model.addAttribute(
                "product",
                new Product()
        );

        return "admin";
    }

    // Save Product
    @PostMapping("/save")
    public String saveProduct(
            @ModelAttribute Product product
    ) {

        productRepository.save(product);

        return "redirect:/admin";
    }

    // Delete Product
    @GetMapping("/delete/{id}")
    public String deleteProduct(
            @PathVariable Long id
    ) {

        productRepository.deleteById(id);

        return "redirect:/admin";
    }

    // Edit Product
    @GetMapping("/edit/{id}")
    public String editProduct(
            @PathVariable Long id,
            Model model
    ) {

        Product product =
                productRepository.findById(id)
                        .orElseThrow();

        model.addAttribute(
                "product",
                product
        );

        model.addAttribute(
                "products",
                productRepository.findAll()
        );

        return "admin";
    }
}