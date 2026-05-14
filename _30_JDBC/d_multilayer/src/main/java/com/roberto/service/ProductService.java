package com.roberto.service;

import com.roberto.exception.ProductNotFoundException;
import com.roberto.model.Product;
import com.roberto.repository.ProductRepository;

import javax.sql.rowset.spi.SyncProviderException;
import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public void registerProduct(String code, String name, BigDecimal price){
        if(code ==null || code.isBlank()) throw new IllegalArgumentException("El codigo es obligatorio");
        if(name ==null || code.isBlank()) throw new IllegalArgumentException("El nombre es obligatorio");
        if(price ==null || price.compareTo(BigDecimal.ZERO)<=0) throw new IllegalArgumentException("El precio debe ser mayor a 0");

        repository.save(code,name,price);
    }

    public List<Product> listProduct(){
        return repository.findAll();
    }

    public  Product findByCode(String code){
        return repository.findByCode(code)
                .orElseThrow(()->new ProductNotFoundException(code));
    }

    public void changePrice(String code, BigDecimal newPrice){
        if(newPrice==null || newPrice.compareTo(BigDecimal.ZERO)<=0) throw new IllegalArgumentException("El nuevo precio debe ser mayor a 0");

        boolean updated = repository.updatePrice(code, newPrice);

        if(!updated) throw new ProductNotFoundException(code);
    }

    public void desactivateProduct(String code){
        boolean updated = repository.desactivate(code);
        if(!updated) throw new ProductNotFoundException(code);
    }


}
