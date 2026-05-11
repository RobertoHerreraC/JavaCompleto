package com.roberto;

import java.time.LocalDateTime;

public record Client(
        int id,
        String fullName,
        String email,
        String phone,
        ClientStatus status,
        LocalDateTime createdAt
) {
}
