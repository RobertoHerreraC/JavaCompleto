package com.roberto;

import java.util.List;

public class Main {
    static void main() {
        DatabaseConfig config = new DatabaseConfig();

        ClientRepository repository = new JdbcClientRepository(config);

        repository.save("Carlos", "carlos@gmail.com","45152311", "ACTIVE");
        repository.save("Ingrid", "ingrid@gmail.com","7875515","ACTIVE");
        repository.save("Kateryn", "kateryn@gmail.com", "659595", "ACTIVE");

        System.out.println("===CLIENTES===");
        List<Client> clients = repository.findAll();
        clients.forEach(System.out::println);

    }
}
