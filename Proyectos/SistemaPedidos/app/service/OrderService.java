package Proyectos.SistemaPedidos.app.service;

import Proyectos.SistemaPedidos.app.dto.AddProductDTO;
import Proyectos.SistemaPedidos.app.dto.OrderResponseDTO;
import Proyectos.SistemaPedidos.app.model.Order;
import Proyectos.SistemaPedidos.app.model.Product;
import Proyectos.SistemaPedidos.app.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private ProductService productService = new ProductService();

    public Order createOrder(){
        return orderRepository.save(new Order(null));
    }

    public void addProduct(AddProductDTO dto){
        Order order = orderRepository.findById(dto.orderId)
                .orElseThrow(()-> new RuntimeException("Pedido no existe"));

        Product product = productService.findById(dto.productId);
        order.addProduct(product);

    }

    public List<OrderResponseDTO> listOrders(){
        return orderRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private OrderResponseDTO mapToDTO(Order order){
        List<String> names = order.getProducts()
                .stream()
                .map(Product::getName)
                .toList();

        return new OrderResponseDTO(
                order.getId(),
                names,
                order.calculateTotal()
        );
    }

}
