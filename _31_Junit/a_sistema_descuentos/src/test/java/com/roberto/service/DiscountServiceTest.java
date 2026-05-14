package com.roberto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountServiceTest {
    private DiscountService discountService;

    @BeforeEach
    void setUp(){
        discountService = new DiscountService();
    }

    @Test
    void shouldCalculateFinalPriceWithDiscount(){
        double price = 100;
        double discount = 10;

        double result = discountService.calculateFinalPrice(price, discount);

        assertEquals(90,result);
    }

    @Test
    void shouldReturnOriginalPriceWhenDiscountIsZero(){
        double price = 150;
        double discount = 0;

        double result = discountService.calculateFinalPrice(price,discount);

        assertEquals(150, result);
    }

    @Test
    void shouldReturnZeroWhenDiscountIsOneHundred(){
        double price = 200;
        double discount = 100;

        double result = discountService.calculateFinalPrice(price, discount);

        assertEquals(0, result);
    }

    @Test
    void shouldThrowExceptionWhenPriceIsZero(){
        double price = 0;
        double discount = 10;

        assertThrows(IllegalArgumentException.class, ()->
            discountService.calculateFinalPrice(price, discount)
        );
    }

    @Test
    void shouldThrowExceptionWhenDiscountIsGreaterThanOneHundred(){
        double price = 100;
        double discount = 120;

        assertThrows(IllegalArgumentException.class,()->
                discountService.calculateFinalPrice(price,discount));
    }
}
