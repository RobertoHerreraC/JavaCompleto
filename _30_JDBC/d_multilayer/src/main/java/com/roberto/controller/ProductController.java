package com.roberto.controller;

import com.roberto.model.Product;
import com.roberto.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    public void create(String code, String name, String price){
        service.registerProduct(code,name,new BigDecimal(price));

        System.out.println("Producto registrado: "+code);
    }

    public void list(){
        List<Product> products = service.listProduct();

        System.out.println("===PRODUCTOS===");
        products.forEach(System.out::println);
    }

    public void find(String code){
        Product product = service.findByCode(code);

        System.out.println("Producto encontrado:");
        System.out.println(product);
    }

    public void updatePrice(String code, String newPrice){
        service.changePrice(code,new BigDecimal(newPrice));
        System.out.println("Precio actualizado: "+code);
    }

    public void desactivate(String code){
        service.desactivateProduct(code);
        System.out.println("Producto desactivado: "+code);
    }
}
