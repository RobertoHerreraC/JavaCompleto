package POO.PY_1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity){
        items.add(new OrderItem(product, quantity));
    }

    public Money calculateTotal(){
        Money total = new Money(0);
        for(OrderItem item : items){
            total = total.add(item.calculateSubtotal());
        }
        return total;
    }

    public void checkout(PaymentMethod paymentMethod){
        Money total = calculateTotal();
        paymentMethod.process(total);
    }
}
