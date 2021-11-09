package com.nicole.cat1.service;

import com.nicole.cat1.model.Product;
import com.nicole.cat1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

        @Autowired
        ProductRepository productRepository;

        public List<Product> getAllProducts(){
            return productRepository.findAll();
        }

        public Product createProduct(String name, String description, Long price, String manufacturer, Integer Id){
            Product product = new Product(Id, name, description, price, manufacturer);

            return productRepository.save(product);
    }

    public int unitPrice;

    public int getQuantity(int quantity) {
        int priceWithoutDiscount = unitPrice * quantity;
        return priceWithoutDiscount;
    }
}
