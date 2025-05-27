import java.util.concurrent.*;
import java.util.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            tasks.add(() -> "Result from task " + finalI);
        }

        List<Future<String>> results = executor.invokeAll(tasks);
        for (Future<String> future : results) {
            System.out.println(future.get());
        }
        executor.shutdown();
    }
}