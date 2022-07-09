import java.util.Random;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class CustomerFactory implements Callable<Void> {
    private int customerCount;
    private final BarberShop barberShop;

    public CustomerFactory(BarberShop barberShop) {
        this.customerCount = 0;
        this.barberShop = barberShop;
    }

    @Override
    public Void call() throws Exception {
        final Random random = new Random();
        while (true) {
            IntStream.range(1, random.nextInt(1, 4)).forEach(i -> {
                this.barberShop.getExecutor().submit(new Customer(this.barberShop, this.barberShop.getBarber(), this.customerCount));
                this.customerCount++;
            });
            Thread.sleep(random.nextInt(1500, 3000));
        }
    }
}
