package _21_hilos.ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class c_encontrar_maximo {
    static void main() {
        int[] numeros = {15, 22, 1, 63, 7, 63, 678, 3, 33, 10, 45, 400};

        ForkJoinPool pool = new ForkJoinPool();
        int max = pool.invoke(new MaxTask(numeros,0,numeros.length));
        System.out.println(max);
        pool.shutdown();
    }
}

class MaxTask extends RecursiveTask<Integer>{
    private static final int THRESHOLD = 100;

    private final int[] numeros;
    private final int inicio;
    private final int fin;

    public MaxTask(int[] numeros, int inicio, int fin) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Integer compute() {
        if(fin-inicio<=THRESHOLD){
            int max = numeros[inicio];
            for (int i = inicio+1; i <fin; i++) {
                if(numeros[i]>max){
                    max=numeros[i];
                }
            }
            return max;
        }

        int medio =  (inicio + fin)/2;
        MaxTask izquierda = new MaxTask(numeros, inicio,medio);
        MaxTask derecha = new MaxTask(numeros, medio, fin);
        izquierda.fork();

        int resultadoDerecha = derecha.compute();
        int resultadoIzquierda = izquierda.join();

        return Math.max(resultadoDerecha,resultadoIzquierda);

    }
}
