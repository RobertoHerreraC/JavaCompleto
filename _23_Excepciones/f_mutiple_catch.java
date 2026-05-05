package _23_Excepciones;

public class f_mutiple_catch {
    static void main() {
        try{
            String texto = "abc";
            int numero = Integer.parseInt(texto);
            int resultado = 10/numero;
            System.out.println("Resultado: "+resultado);
        }catch (NumberFormatException e){
            System.out.println("El texto no es un numero valido");
        }catch (ArithmeticException e){
            System.out.println("No se puede dividir entre cero");
        }
    }
}
