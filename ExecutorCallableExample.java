import java.util.concurrent.*;

public class ExecutorCallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Callable<String> task = () -> "Task executed";
        Future<String> future = service.submit(task);
        System.out.println(future.get());
        service.shutdown();
    }
}
