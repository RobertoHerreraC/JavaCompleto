package __Proyectos.SistemaPedidos.app.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Order(Long id){
        this.id = id;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public double calculateTotal(){
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

}
