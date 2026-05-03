package _1_POO.PY_1;

public class OrderItem {
    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity){
        if(quantity <=0){
            throw new IllegalArgumentException("Invalid quantity");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Money calculateSubtotal(){
        return new Money(product.getPrice().getAmount()*quantity);
    }
}
