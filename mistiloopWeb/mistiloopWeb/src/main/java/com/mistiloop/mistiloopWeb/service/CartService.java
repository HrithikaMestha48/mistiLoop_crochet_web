package com.mistiloop.mistiloopWeb.service;

import com.mistiloop.mistiloopWeb.model.CartItem;
import com.mistiloop.mistiloopWeb.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Product product) {

        for(CartItem item : cartItems){

            if(item.getProduct().getId().equals(product.getId())){

                item.setQuantity(item.getQuantity()+1);
                return;
            }
        }

        cartItems.add(new CartItem(product,1));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotal() {

        return cartItems.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public void removeItem(Long id){

        cartItems.removeIf(
                item -> item.getProduct().getId().equals(id)
        );
    }
}