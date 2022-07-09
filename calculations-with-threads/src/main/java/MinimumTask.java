import java.util.Arrays;
import java.util.concurrent.Callable;

public class MinimumTask implements Callable<Integer> {

    private final int[] numbers;

    public MinimumTask(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread " + Thread.currentThread().getId() + " is calculating the minimum number");

        return Arrays.stream(this.numbers)
                .min()
                .getAsInt();
    }
}
