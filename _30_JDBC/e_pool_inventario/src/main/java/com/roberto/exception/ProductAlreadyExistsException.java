package com.roberto.exception;

public class ProductAlreadyExistsException extends  RuntimeException{
    public ProductAlreadyExistsException(String code){
        super("Ya existe un producto con codigo: "+code);
    }
}
