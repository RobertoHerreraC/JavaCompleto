package _16_lambda;

public class lambda_sin_parametro {
    static void main() {
        Runnable tarea = () -> System.out.println("Sin parametro");
        tarea.run();
    }
}
