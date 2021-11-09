package com.nicole.cat1.controller;
import com.nicole.cat1.model.Product;
import com.nicole.cat1.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductServices productServices;

    @GetMapping("/get-all")
    public List<Product> getAll(){
        return productServices.getAllProducts();
    }

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product){
        return productServices.createProduct(product.getName(), product.getDescription(), product.getPrice(),
                product.getManufacturer(), product.getId());
    }
    @GetMapping("/get-quantity")
    public int getQuantity() {return productServices.getQuantity(4000);}
}
