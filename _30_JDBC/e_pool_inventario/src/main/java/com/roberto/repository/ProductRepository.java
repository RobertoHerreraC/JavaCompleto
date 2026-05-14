package com.roberto.repository;

import com.roberto.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void save(String code, String name, BigDecimal price, int stock);
    List<Product> findAllActive();
    Optional<Product> findByCode(String code);
    boolean updateStock(String code, int newStock);
    boolean desactivate(String code);
}
