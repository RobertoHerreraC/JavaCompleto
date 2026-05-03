package _21_hilos.ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class e_parallel_stream {
    static void main() {
        ForkJoinPool pool = new ForkJoinPool(2);

        pool.submit(()->{
            IntStream.rangeClosed(1,10)
                    .parallel()
                    .forEach(n->{
                        System.out.println(n+"->"+Thread.currentThread().getName());
                    });
        }).join();

        pool.shutdown();
    }
}
