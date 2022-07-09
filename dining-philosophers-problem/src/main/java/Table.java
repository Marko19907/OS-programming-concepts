import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Table {
    private final List<Philosopher> philosophers = new ArrayList<>();
    private final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    public Table() {
        IntStream.range(0, 5).forEach(i -> this.philosophers.add(new Philosopher(this, i)));
    }

    public void run() {
        this.philosophers.forEach(this.executor::submit);
    }

    public static void main(String[] args) {
        new Table().run();
    }

    public synchronized void printTable() {
        final StringBuilder builder = new StringBuilder();
        IntStream.range(0, this.philosophers.size()).forEachOrdered(i -> {
            builder.append("Philosopher ").append(i).append(" : ");
            builder.append(this.philosophers.get(i).getState()).append("\n");
        });
        System.out.println(builder);
    }

    public synchronized boolean canEat(final int index) {
        return Stream.of(this.philosophers.get((index + 4) % 5), this.philosophers.get((index + 1) % 5))
                .noneMatch(e -> e.getState() == State.EATING);
    }
}
