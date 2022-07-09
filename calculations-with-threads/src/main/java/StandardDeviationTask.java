import java.util.Arrays;
import java.util.concurrent.Callable;

public class StandardDeviationTask implements Callable<Double> {

    private final int[] numbers;

    public StandardDeviationTask(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Double call() throws Exception {
        System.out.println("Thread " + Thread.currentThread().getId() + " is calculating the standard deviation");

        double median = this.calculateMedian();

        double sum = Arrays.stream(this.numbers)
                .mapToDouble(x -> Math.pow(Math.abs(x - median), 2))
                .sum();

        return Math.sqrt(sum / this.numbers.length);
    }

    private double calculateMedian() {
        Arrays.sort(this.numbers);
        if (this.numbers.length % 2 == 0) {
            return ((double) this.numbers[this.numbers.length / 2] + (double) this.numbers[this.numbers.length / 2 - 1]) / 2;
        }
        else {
            return this.numbers[this.numbers.length / 2];
        }
    }
}
