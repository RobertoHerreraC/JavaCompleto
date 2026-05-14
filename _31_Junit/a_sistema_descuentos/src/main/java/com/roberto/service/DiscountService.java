package com.roberto.service;

public class DiscountService {

    public double calculateFinalPrice(double price, double discountPercentage){
        if(price<=0) throw new IllegalArgumentException("El precio deber ser mayor que 0");
        if(discountPercentage<0 || discountPercentage>100) throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");

        double discountAmount = price * (discountPercentage/100);
        return price - discountAmount;
    }
}
