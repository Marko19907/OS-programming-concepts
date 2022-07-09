import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CalculationsWithThreads {

    private static final int[] numbers = new int[] {
            90, 81, 78, 95, 79, 72, 85
    };

    private final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

    private long minimum;
    private long maximum;
    private double average;
    private double standardDeviation;


    public CalculationsWithThreads() {
        this.minimum = 0;
        this.maximum = 0;
        this.average = 0d;
        this.standardDeviation = 0d;
    }

    private void runTasks() {
        System.out.println("Thread " + Thread.currentThread().getId() + " is starting the tasks");

        var minTask = new MinimumTask(numbers);
        Future<Integer> minFuture = this.executor.submit(minTask);

        var maxTask = new MaximumTask(numbers);
        Future<Integer> maxFuture = this.executor.submit(maxTask);

        var averageTask = new AverageTask(numbers);
        Future<Double> averageFuture = this.executor.submit(averageTask);

        var standardDeviationTask = new StandardDeviationTask(numbers);
        Future<Double> standardDeviationFuture = this.executor.submit(standardDeviationTask);

        try {
            this.minimum = minFuture.get();
            this.maximum = maxFuture.get();
            this.average = averageFuture.get();
            this.standardDeviation = standardDeviationFuture.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Min: " + this.minimum);
        System.out.println("Max: " + this.maximum);
        System.out.println("Average: " + this.average);
        System.out.println("Standard deviation: " + this.standardDeviation);
    }

    private void shutDownExecutor() {
        this.executor.shutdown();
    }

    public static void main(String[] args) {
        var calculator = new CalculationsWithThreads();
        calculator.runTasks();
        calculator.shutDownExecutor();
    }
}
