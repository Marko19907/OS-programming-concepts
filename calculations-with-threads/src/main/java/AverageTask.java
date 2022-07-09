import java.util.Arrays;
import java.util.concurrent.Callable;

public class AverageTask implements Callable<Double> {

    private final int[] numbers;

    public AverageTask(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Double call() throws Exception {
        System.out.println("Thread " + Thread.currentThread().getId() + " is calculating the average number");

        return Arrays.stream(this.numbers)
                .average()
                .getAsDouble();
    }
}
