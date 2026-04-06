package Proyectos.SistemaPedidos.app.controller;

import Proyectos.SistemaPedidos.app.dto.AddProductDTO;
import Proyectos.SistemaPedidos.app.dto.ProductDTO;
import Proyectos.SistemaPedidos.app.service.OrderService;
import Proyectos.SistemaPedidos.app.service.ProductService;

public class OrderController {
    private OrderService orderService = new  OrderService();
    private ProductService productService = new  ProductService();

    public void createProduct(String name, double price){
        try {
            ProductDTO product = new ProductDTO();
            product.name = name;
            product.price = price;
            System.out.println("Se creo el producto: "+ product.name+" - "+ productService.save(product).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createOrder(){
        System.out.println("Se creo la order: "  + orderService.createOrder().getId());
    }

    public void addProductToOrder(Long orderId, Long productId){
        try {
            AddProductDTO dto = new AddProductDTO();

            dto.orderId = orderId;
            dto.productId = productId;
            orderService.addProduct(dto);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void listOrder(){
        orderService.listOrders().forEach(System.out::println);
    }
}
