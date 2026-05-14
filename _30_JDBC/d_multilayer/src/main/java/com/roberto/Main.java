package com.roberto;

import com.roberto.config.DatabaseConfig;
import com.roberto.controller.ProductController;
import com.roberto.repository.JdbcProductRepository;
import com.roberto.repository.ProductRepository;
import com.roberto.service.ProductService;

public class Main {

    static void main() {
        DatabaseConfig config = new DatabaseConfig();
        ProductRepository repository = new JdbcProductRepository(config);
        ProductService service = new ProductService(repository);
        ProductController controller = new ProductController(service);

        try{
            controller.create("P001","Teclado mecanico", "180.50");
            controller.create("P002", "Mouse inalambrico", "95.90");
            controller.list();
            controller.find("P001");
            controller.updatePrice("P001","199.9");
            controller.desactivate("P002");
            controller.list();
        }catch (RuntimeException e){
            System.out.println("ERROR:"+e.getMessage());
        }
    }
}
