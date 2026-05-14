package com.roberto.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Product(
        long id,
        String code,
        String name,
        BigDecimal price,
        int stock,
        boolean active,
        LocalDateTime createdAt
) {
}
