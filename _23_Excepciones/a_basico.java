package _23_Excepciones;

public class a_basico {
    static void main() {
        try{
            int resutado = dividir(10,0);
            System.out.println(resutado);
        }catch (ArithmeticException e){
            System.out.println("No se puede dividir entre cero");
        }
    }

    public static int dividir(int a, int b){
        return a/b;
    }
}
