package com.mistiloop.mistiloopWeb.controller;

import com.mistiloop.mistiloopWeb.entity.Product;
import com.mistiloop.mistiloopWeb.repository.ProductRepository;
import com.mistiloop.mistiloopWeb.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    private final CartService cartService;
    private final ProductRepository productRepository;

    public CartController(
            CartService cartService,
            ProductRepository productRepository) {

        this.cartService = cartService;
        this.productRepository = productRepository;
    }

    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id){

        Product product =
                productRepository.findById(id).orElseThrow();

        cartService.addToCart(product);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(Model model){

        model.addAttribute(
                "cartItems",
                cartService.getCartItems()
        );

        model.addAttribute(
                "total",
                cartService.getTotal()
        );

        return "cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String remove(@PathVariable Long id){

        cartService.removeItem(id);

        return "redirect:/cart";
    }
}