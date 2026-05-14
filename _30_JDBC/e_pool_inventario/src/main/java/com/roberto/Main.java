package com.roberto;

import com.roberto.config.ConnectionFactory;
import com.roberto.config.DatabaseConfig;
import com.roberto.controller.ProductController;
import com.roberto.repository.JdbcProductRepository;
import com.roberto.repository.ProductRepository;
import com.roberto.service.ProductService;

public class Main {
    static void main() {
        DatabaseConfig databaseConfig = new DatabaseConfig();

        try(
                ConnectionFactory connectionFactory = new ConnectionFactory(databaseConfig);
                ){
            ProductRepository repository = new JdbcProductRepository(connectionFactory);
            ProductService service = new ProductService(repository);

            ProductController controller = new ProductController(service);

            controller.create("P001","Teclado mecanico","180.50",15);
            controller.create("P002", "Mouse inalambrico", "95.9", 30);
            controller.create("P003", "Monitor 24 pulgadas", "650.00",8);

            controller.listActive();
            controller.find("P001");
            controller.updateStock("P001", 20);
            controller.desativate("P002");
            controller.listActive();
        }catch (RuntimeException e){
            System.out.println("ERROR:"+e.getMessage());
        }
    }
}
