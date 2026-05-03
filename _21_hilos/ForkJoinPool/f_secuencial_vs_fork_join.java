package _21_hilos.ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class f_secuencial_vs_fork_join {
    static void main() {
        int[] numeros = IntStream.rangeClosed(1,5_000_000).toArray();
        long inicioSec = System.currentTimeMillis();
        long sumaSec = sumaSecuencia(numeros);
        long finSec = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        long iniciPar = System.currentTimeMillis();
        long sumaPar = pool.invoke(new SumaGrandeTask(numeros,0,numeros.length));
        long finPar = System.currentTimeMillis();
        pool.shutdown();

        System.out.println("Suma secuencial: " + sumaSec);
        System.out.println("Tiempo secuencial: " + (finSec-inicioSec)+"ms");

        System.out.println("Suma fork/join: " + sumaPar);
        System.out.println("Tiempo fork/join: " + (finPar-iniciPar)+"ms");
    }

    private static long sumaSecuencia(int[] numeros){
        long suma =0;
        for(int n : numeros){
            suma+=n;
        }
        return suma;
    }
}

class SumaGrandeTask extends RecursiveTask<Long>{
    private final int THRESHOLD = 10_000;

    private final int[] numeros;
    private final int inicio;
    private final int fin;
    public SumaGrandeTask(int[] numeros, int inicio, int fin) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Long compute() {
        if(this.fin - this.inicio < THRESHOLD) {
            long suma =0;
            for(int i=this.inicio;i<this.fin;i++) {
                suma += this.numeros[i];
            }
            return suma;
        }

        int medio = (this.fin + this.inicio)/2;

        SumaGrandeTask izquierda = new SumaGrandeTask(numeros, inicio, medio);
        SumaGrandeTask derecha = new SumaGrandeTask(numeros, medio, fin);

        izquierda.fork();
        Long resultadoDerecha = derecha.compute();
        Long resultadoIzquierda = izquierda.join();

        return resultadoDerecha+resultadoIzquierda;
    }
}
