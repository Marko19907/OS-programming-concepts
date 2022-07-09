import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class Consumer implements Callable<Void> {
    private static final int LIMIT = 10;
    private final LinkedList<Character> receivedData;
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
        this.receivedData = new LinkedList<>();
    }

    private void printList() {
        System.out.println("Printing received data: ");
        System.out.println("Data size: " + this.receivedData.size());

        Collections.sort(this.receivedData);
        this.receivedData.forEach(System.out::println);

        System.out.println("Done printing data!");
    }

    @Override
    public Void call() throws Exception {
        Thread.sleep(20); // Delay the consumer

        System.out.println("Consumer started getting data . . .");

        int index = 0;
        while (index < LIMIT) {
            if (!this.buffer.isEmpty()) {
                this.receivedData.add(this.buffer.get());
                System.out.println("Consumed " + this.receivedData.peekLast());

                index++;
            }
        }

        System.out.println("Finished getting the data . . .");

        this.printList();

        return null;
    }
}
