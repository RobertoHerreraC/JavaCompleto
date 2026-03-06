package POO.PY_1;

public class Product {
    private final String name;
    private final Money price;

    public Product(String name, Money price){
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name.");
        }
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public Money getPrice(){

        return price;
    }
}
