import java.util.List;
import java.util.concurrent.Callable;

public class Producer implements Callable<Void> {
    private static final int LIMIT = 10;
    private final Buffer buffer;
    private final List<Character> data = "0123456789".chars().mapToObj(i -> (char) i).toList();

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public Void call() throws Exception {
        System.out.println("Producer stated adding data . . .");

        int index = 0;
        while (index < LIMIT) {
            if (!this.buffer.isFull()) {
                this.buffer.put(this.data.get(index));
                System.out.println("Added data: " + this.data.get(index));

                index++;
            }
        }

        System.out.println("Producer finished adding data!");

        return null;
    }
}
