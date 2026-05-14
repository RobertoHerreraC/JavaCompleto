package com.roberto.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Product(
        int id,
        String code,
        String name,
        BigDecimal price,
        boolean active,
        LocalDateTime createdAt
) {
}
