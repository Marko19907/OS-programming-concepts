import java.util.Random;
import java.util.concurrent.Callable;

enum State {
    ACTIVE,
    SLEEPING,
}

public class Barber implements Callable<Void> {
    private final BarberShop barberShop;
    private State state = State.SLEEPING;

    public Barber(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    public synchronized void wakeUp() {
        if (this.state == State.SLEEPING) {
            System.out.println("Barber woke up");
            this.state = State.ACTIVE;
        }
    }

    private void sleep() {
        this.state = State.SLEEPING;
        System.out.println("Barber went to sleep");
    }

    @Override
    public Void call() throws Exception {
        final Random random = new Random();
        while (true) {
            if (this.barberShop.isEmpty() && this.state != State.SLEEPING) {
                this.sleep();
            } else if (this.state == State.ACTIVE) {
                Customer customer = this.barberShop.getNextCustomer();
                System.out.println("Barber treated customer " + customer.getIndex());
                Thread.sleep(random.nextInt(3000, 5000));
            }
        }
    }
}
