package _1_POO.PY_1;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void process(Money amount) {
        System.out.println("Paying with a credit card: "+ amount.getAmount());
    }
}
