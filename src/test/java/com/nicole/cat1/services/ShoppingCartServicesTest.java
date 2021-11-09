package com.nicole.cat1.services;

import com.nicole.cat1.model.Cart;
import com.nicole.cat1.model.Product;
import com.nicole.cat1.repository.CartRepository;
import com.nicole.cat1.service.ProductServices;
import com.nicole.cat1.service.ShoppingCartServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServicesTest {

    @Mock
    CartRepository cartRepository;

    @InjectMocks
    ShoppingCartServices shoppingCartServices;


    @Test
    public void returnCartItems(){
        when(cartRepository.findAll()).thenReturn(Arrays.asList(new Cart(1,3),new Cart(2,2),new Cart(3,7)));
        assertEquals("3",shoppingCartServices.getAllItems().get(2).getProductId());
    }

    @Test
    public void createCart(){
        when(cartRepository.save(ArgumentMatchers.any(Cart.class))).thenReturn(null);
        assertEquals(2,ShoppingCartServices.createItems(1,4));
    }

    @Test
    public void deleteItem(){
        Cart cartitems = new Cart(1,4);
        when(cartRepository.findById(cartitems.getProductId())).thenReturn(Optional.of(cartitems));

        shoppingCartServices.deleteItem(cartitems.getProductId());

        verify(cartRepository).deleteById(cartitems.getProductId());

    }

    @Test
    public void addItem(){
        when(cartRepository.save(ArgumentMatchers.any(Cart.class)));
    }

}
