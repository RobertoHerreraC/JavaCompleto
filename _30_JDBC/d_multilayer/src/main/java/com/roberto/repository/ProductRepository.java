package com.roberto.repository;

import com.roberto.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void save(String code, String name, BigDecimal price);
    List<Product> findAll();
    Optional<Product> findByCode(String code);
    boolean updatePrice(String code, BigDecimal newPrice);
    boolean desactivate(String code);
}
