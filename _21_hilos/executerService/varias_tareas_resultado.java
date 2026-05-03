package _21_hilos.executerService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class varias_tareas_resultado {
    static void main() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(4, 5, 6);
        List<Integer> c = List.of(7, 8, 9);
        try{
            Future<Integer> fa = executor.submit(()-> sumar(a));
            Future<Integer> fb = executor.submit(()-> sumar(b));
            Future<Integer> fc = executor.submit(()-> sumar(c));
            int total = fa.get() + fb.get() + fc.get();
            System.out.println(total);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            executor.shutdown();
        }
    }

    private static int sumar(List<Integer> numeros){
        return numeros.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
