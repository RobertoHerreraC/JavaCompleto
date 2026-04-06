package Proyectos.SistemaPedidos.app;

import Proyectos.SistemaPedidos.app.controller.OrderController;

public class Main {
    public static void main(String[] args) {
        try{
            OrderController orderController = new OrderController();
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



        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
