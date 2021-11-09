package com.nicole.cat1.controller;

import com.nicole.cat1.model.Cart;
import com.nicole.cat1.service.ShoppingCartServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CartController {

    @GetMapping("/get-items")
    public List<Cart> getAll(){
        return ShoppingCartServices.getAllItems();
    }
    @PostMapping("/add-item")
    public Cart addItem(@RequestBody Cart cart){
        return ShoppingCartServices.createItems(cart.getProductId(), cart.getQuantity(4000));
    }
}
