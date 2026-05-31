package com.mistiloop.mistiloopWeb.controller;

import com.mistiloop.mistiloopWeb.entity.Product;
import com.mistiloop.mistiloopWeb.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute(
                "products",
                productService.getAllProducts()
        );

        return "home";
    }

    @GetMapping("/product/{id}")
    public String productDetails(
            @PathVariable Long id,
            Model model) {

        Product product =
                productService.getProductById(id);

        model.addAttribute("product", product);

        return "product-details";
    }
}