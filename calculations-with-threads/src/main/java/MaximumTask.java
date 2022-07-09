import java.util.Arrays;
import java.util.concurrent.Callable;

public class MaximumTask implements Callable<Integer> {

    private final int[] numbers;

    public MaximumTask(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread " + Thread.currentThread().getId() + " is calculating the maximum number");

        return Arrays.stream(this.numbers)
                .max()
                .getAsInt();
    }
}
