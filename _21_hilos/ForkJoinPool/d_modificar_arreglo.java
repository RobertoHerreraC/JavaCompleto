package _21_hilos.ForkJoinPool;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class d_modificar_arreglo {
    static void main() {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MultiplicarTask(numeros,0,numeros.length));
        System.out.println(Arrays.toString(numeros));
        pool.shutdown();
    }
}

class MultiplicarTask extends RecursiveAction {
    private final int THRESHOLD = 3;

    private final int[] numeros;
    private final int inicio;
    private final int fin;

    public MultiplicarTask(int[] numeros, int inicio, int fin) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected void compute() {
        if(fin-inicio<THRESHOLD) {
            for (int i = inicio; i < fin; i++) {
                numeros[i] *=2;
            }
            return;
        }

        int medio = (inicio + fin)/2;
        MultiplicarTask izquierda = new MultiplicarTask(numeros,inicio,medio);
        MultiplicarTask derecha = new MultiplicarTask(numeros,medio,fin);

        invokeAll(izquierda,derecha);
    }
}
