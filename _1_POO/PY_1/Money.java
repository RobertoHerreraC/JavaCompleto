package _1_POO.PY_1;

public final class Money {
    private final double amount;

    public Money(double amount){
        if(amount<0){
            throw new IllegalArgumentException("The amount cannot be negative.");
        }
        this.amount = amount;
    }
     public double getAmount(){
        return amount;
     }


    public Money add(Money other){
        return new Money(this.amount  + other.getAmount());
    }
}
