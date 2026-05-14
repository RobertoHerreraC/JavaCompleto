package com.roberto;

import java.util.List;

public interface ClientRepository {
    void save(String fullName, String email, String phone, String status);
    List<Client> findAll();
}
