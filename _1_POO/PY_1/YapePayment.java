package _1_POO.PY_1;

public class YapePayment implements PaymentMethod {
    @Override
    public void process(Money amount) {
        System.out.println("Paying with Yape: "+ amount.getAmount());
    }
}
