package _21_hilos.ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class b_sumar_arreglo_RecursiveTask {
    static void main() {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool pool = new ForkJoinPool();
        int resultado = pool.invoke(new SumaTask(numeros,0,numeros.length));
        System.out.println(resultado);
        pool.shutdown();
    }
}

class SumaTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 3;

    private final int[] numeros;
    private final int inicio;
    private final int fin;

    public SumaTask(int[] numeros, int inicio, int fin) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Integer compute() {
        if(fin - inicio <= THRESHOLD){
            int suma = 0;
            for(int i =inicio;i<fin;i++){
                suma += this.numeros[i];

            }
            return suma;
        }
        int medio = (inicio + fin)/2;
        SumaTask izquierda = new SumaTask(numeros, inicio,medio);
        SumaTask derecha = new SumaTask(numeros,medio,fin);

        izquierda.fork();

        int resultadoDerecha = derecha.compute();
        int resultadoIzquierda = izquierda.join();

        return resultadoIzquierda + resultadoDerecha;
    }
}
