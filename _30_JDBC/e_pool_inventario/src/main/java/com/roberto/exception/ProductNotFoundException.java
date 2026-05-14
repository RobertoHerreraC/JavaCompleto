package com.roberto.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String code){
        super("No existe un producto con codigo: "+code);
    }
}
