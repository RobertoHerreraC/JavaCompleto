package com.roberto;

import java.time.LocalDateTime;

public record Client(
        int id,
        String fullName,
        String email,
        String phone,
        String status,
        LocalDateTime createdAt
) {
}
