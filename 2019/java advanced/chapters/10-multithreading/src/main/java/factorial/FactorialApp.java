package factorial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialApp {
    public static void main(String[] args) throws Exception {
        FactorialCalculator fac = new FactorialCalculator(25);
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Long> future = es.submit(fac);

        while (!future.isDone()) {
            System.out.println("*Waiting*");
        }

        Long factorial = future.get();
        System.out.println(factorial);
        es.shutdown();
    }
}