package _11_generics;

public class clave_valor {
    static void main() {
        Par<String, Integer> p1 = new Par<>("edad", 30);
        Par<String, Double> p2 = new Par<>("Precio",99.9);

        System.out.println(p1.getClave()+":"+p1.getValor());
        System.out.println(p2.getClave()+":"+p2.getValor());


    }
}

class Par<K,V>{
    private K clave;
    private V valor;

    public Par(K clave, V valor){
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave(){
        return clave;
    }
    public V getValor(){
        return valor;
    }
}
