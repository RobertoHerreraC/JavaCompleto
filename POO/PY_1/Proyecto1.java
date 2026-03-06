package POO.PY_1;

public class Proyecto1 {
    static void main() {
        Product laptop = new Product("laptop", new Money(2600));
        Product mouse = new Product("mouse", new Money(100));

        Order order = new Order();
        order.addItem(laptop,1);
        order.addItem(mouse,5);

        PaymentMethod crediCard = new CreditCardPayment();
        order.checkout(crediCard);
    }
}
