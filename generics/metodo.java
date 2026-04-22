package generics;

public class metodo {
    static void main() {
        imprimirValor("Roberto");
        imprimirValor(15);
        imprimirValor(true);
    }

    public static <T> void imprimirValor(T obj){
        System.out.println("Valor: "+obj);
    }
}
