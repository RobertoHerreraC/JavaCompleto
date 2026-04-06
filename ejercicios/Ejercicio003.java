package ejercicios;

public class Ejercicio003 {
    static void main() {
        try{
            System.out.println(dividir(10,0));
        }catch(ArithmeticException e){
            System.out.println("No se puede dividir entre 0: "+e.getMessage());
        }
    }

    public static int dividir(int a, int b){
        return a/b;
    }
}
