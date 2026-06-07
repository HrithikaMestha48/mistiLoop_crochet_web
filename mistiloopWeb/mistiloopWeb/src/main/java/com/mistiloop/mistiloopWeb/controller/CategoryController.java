package com.mistiloop.mistiloopWeb.controller;

import com.mistiloop.mistiloopWeb.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    private final ProductRepository productRepository;

    public CategoryController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/flowers")
    public String flowers(Model model){

        model.addAttribute(
                "products",
                productRepository.findByCategory("FLOWERS")
        );

        model.addAttribute(
                "categoryName",
                "Crochet Flowers"
        );

        return "category-products";
    }

    @GetMapping("/keychains")
    public String keychains(Model model){

        model.addAttribute(
                "products",
                productRepository.findByCategory("KEYCHAINS")
        );

        model.addAttribute(
                "categoryName",
                "Crochet Keychains"
        );

        return "category-products";
    }

    @GetMapping("/sweaters")
    public String sweaters(Model model){

        model.addAttribute(
                "products",
                productRepository.findByCategory("SWEATERS")
        );

        model.addAttribute(
                "categoryName",
                "Crochet Sweaters"
        );

        return "category-products";
    }

    @GetMapping("/wallhangings")
    public String wallhangings(Model model){

        model.addAttribute(
                "products",
                productRepository.findByCategory("WALL_HANGINGS")
        );

        model.addAttribute(
                "categoryName",
                "Wall Hangings"
        );

        return "category-products";
    }
}