package com.roberto.service;

import com.roberto.exception.ProductNotFoundException;
import com.roberto.model.Product;
import com.roberto.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public void registerProduct(String code, String name, BigDecimal price, int stock){
        validateCode(code);
        validateName(name);
        validatePrice(price);
        validateStock(stock);
        repository.save(code,name, price,stock);
    }

    public List<Product> listActiveProducts(){
        return repository.findAllActive();
    }

    public Product findProduct(String code){
        validateCode(code);
        return repository.findByCode(code).orElseThrow(()->new ProductNotFoundException(code));
    }

    public void changeStock(String code, int newStock){
        validateCode(code);
        validateStock(newStock);

        boolean updated = repository.updateStock(code, newStock);
        if(!updated) throw new ProductNotFoundException(code);
    }

    public void desativateProduct(String code){
        validateCode(code);

        boolean desactivated = repository.desactivate(code);
        if(!desactivated) throw new ProductNotFoundException(code);
    }


    private void validateCode(String code){
        if(code==null||code.isBlank()) throw new IllegalArgumentException("El codigo es obligatorio");
    }

    private void validateName(String name){
        if(name==null||name.isBlank()) throw new IllegalArgumentException("El nombre es obligatorio");
    }

    private void validatePrice(BigDecimal price){
        if(price==null|| price.compareTo(BigDecimal.ZERO)<=0) throw new IllegalArgumentException("El precio debe ser mayor a 0");
    }

    private void validateStock(int stock){
        if(stock<0) throw new IllegalArgumentException("El stock no puede ser negativo");
    }


}
