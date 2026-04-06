package Proyectos.SistemaPedidos.app.dto;

import java.util.List;

public class OrderResponseDTO {
    public Long id;
    public List<String> products;
    public double total;

    public OrderResponseDTO(Long id, List<String> products, double total){
        this.id = id;
        this.products = products;
        this.total = total;
    }
}
