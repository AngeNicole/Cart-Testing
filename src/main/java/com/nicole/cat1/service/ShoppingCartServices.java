package com.nicole.cat1.service;

import com.nicole.cat1.model.Cart;
import com.nicole.cat1.model.Product;
import com.nicole.cat1.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartServices {

    @Autowired
    static
    CartRepository cartRepository;

    public Cart createCart(){
        Cart cart = new Cart();

        return cartRepository.save(cart);
    }

    public static List<Cart> getAllItems(){
        return cartRepository.findAll();
    }

    public static Cart createItems(Integer productId, Integer quantity){
        Cart cart = new Cart(productId, quantity);

        return cartRepository.save(cart);
    }

    Map<Cart, Integer> quantities = new HashMap<>();

    public void addQuantinty(Cart cart) {
        int currentQuantity = getCurrentQuantity(cart);
        quantities.put(cart, currentQuantity + 1);
    }

    private int getCurrentQuantity(Cart cart) {
        return quantities.get(cart) == null ? 0 : quantities.get(cart);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Cart cart : quantities.keySet()) {
            totalPrice += cart.getQuantity(quantities.get(cart));
        }
        return totalPrice;
    }

    public void deleteItem(Integer id){
        cartRepository.findById(id)
                .orElseThrow( ()->new RuntimeException("Student not found with id"+ id));
        cartRepository.deleteById(id);
    }

}
