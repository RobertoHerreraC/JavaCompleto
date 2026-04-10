package Proyectos.SistemaPedidos.app;

import Proyectos.SistemaPedidos.app.controller.OrderController;
import Proyectos.SistemaPedidos.app.repository.OrderRepository;
import Proyectos.SistemaPedidos.app.repository.ProductRepository;
import Proyectos.SistemaPedidos.app.service.OrderService;
import Proyectos.SistemaPedidos.app.service.ProductService;

public class Main {
    public static void main(String[] args) {
        try{
            ProductRepository productRepository = new ProductRepository();
            OrderRepository orderRepository = new OrderRepository();
            ProductService productService = new ProductService(productRepository);
            OrderService orderService = new OrderService(orderRepository, productService);

            OrderController orderController = new OrderController(orderService, productService);
            orderController.createProduct("Lapices", 1.2);
            orderController.createProduct("Papel", 0.50);
            orderController.createProduct("Silicona",0.00);
            orderController.createProduct("Colores", 5.50);
            orderController.createProduct("Cartulina", 2.00);

            orderController.createOrder();
            orderController.addProductToOrder(1L,3L);
            orderController.addProductToOrder(1L,1L);
            orderController.addProductToOrder(2L,2L);
            orderController.addProductToOrder(1L,10L);
            orderController.addProductToOrder(1L,4L);

            orderController.listOrder();

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
