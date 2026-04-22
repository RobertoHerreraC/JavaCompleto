package lambda;

public class basica_interfaz_funcional {
    static void main() {
        Operacion suma = (a,b)->a+b;
        Operacion multiplicacion = (a,b)->a*b;
        System.out.println("Suma: "+suma.aplicar(10,5));
        System.out.println("Multiplicacion: "+multiplicacion.aplicar(10,5));
    }

}

@FunctionalInterface
interface Operacion{
    int aplicar(int a, int b);
}
