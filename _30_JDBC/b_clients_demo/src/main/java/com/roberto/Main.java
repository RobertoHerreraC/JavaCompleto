package com.roberto;

import java.util.List;
import java.util.Optional;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc_demo";
    private static final String USER = "root";
    private static final String PASSWORD = "DevPassword123";


    static void main() {
        ClientRepository repository = new ClientRepository(URL,USER,PASSWORD);

        repository.save(
                "Roberto Herrera",
                "roberto@gmail.com",
                "12399994"
        );

        repository.save(
                "Kateryn Levano",
                "kateryn@gmail.com",
                "13287441"
        );

        List<Client> clients = repository.findAll();

        System.out.println("=====CLIENTES=====");
        clients.forEach(System.out::println);

        System.out.println("== BUSCAR POR EMAIL ==");

        Optional<Client> client = repository.findByEmail("roberto@gmail.com");

        client.ifPresentOrElse(
                System.out::println,
                ()-> System.out.println("Cliente no encontrado")
        );

        repository.updatePhone(
                "roberto@gmail.com",
                "900000000"
        );

        repository.desactivate("kateryn@gmail.com");

        System.out.println("=== CLIENTES ACTUALIZADOS ===");
        repository.findAll().forEach(System.out::println);
    }
}
