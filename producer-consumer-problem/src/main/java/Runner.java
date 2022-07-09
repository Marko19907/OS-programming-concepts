import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Runner {
    private final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

    private void run() {
        Buffer buffer = new Buffer(5);

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Future<Void> future1 = this.executor.submit(producer);
        Future<Void> future2 = this.executor.submit(consumer);

        try {
            future1.get();
            future2.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Buffer is empty: " + buffer.isEmpty());
    }

    private void shutdown() {
        this.executor.shutdown();
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();
        runner.shutdown();
    }
}
