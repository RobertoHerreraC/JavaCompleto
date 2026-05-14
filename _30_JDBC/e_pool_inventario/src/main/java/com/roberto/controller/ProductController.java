package com.roberto.controller;

import com.roberto.model.Product;
import com.roberto.service.ProductService;

import java.math.BigDecimal;

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    public void create(String code, String name, String price, int stock){
        productService.registerProduct(code,name,new BigDecimal(price),stock);

        System.out.println("Producto registrado: "+code);
    }

    public void listActive(){
        System.out.println("==== PRODUCTOS ACTIVOS ====");
        productService.listActiveProducts().forEach(System.out::println);
    }

    public void find(String code){
        Product product = productService.findProduct(code);
        System.out.println("Producto encontrado:");
        System.out.println(product);
    }

    public void updateStock(String code, int newStock)
    {
        productService.changeStock(code, newStock);
        System.out.println("Stock actualizado: "+code);
    }

    public void desativate(String code){
        productService.desativateProduct(code);
        System.out.println("Producto desactivado: "+code);
    }
}
