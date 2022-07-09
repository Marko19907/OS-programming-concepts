import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class BarberShop {
    private static final int SEATS = 5;
    private final Barber barber;
    private final LinkedList<Customer> chairs;
    private final CustomerFactory customerFactory;
    private final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);

    public BarberShop() {
        this.barber = new Barber(this);
        this.chairs = new LinkedList<>();
        this.customerFactory = new CustomerFactory(this);
        this.executor.submit(this.barber);
        this.executor.submit(this.customerFactory);
    }

    public static void main(String[] args) {
        new BarberShop();
    }

    public synchronized boolean canSit() {
        return !this.isEmpty() && !this.isFull();
    }

    public synchronized boolean isEmpty() {
        return this.chairs.isEmpty();
    }

    public synchronized boolean isFull() {
        return this.chairs.size() == SEATS;
    }

    public void printCurrentQueue() {
        System.out.println("There are currently: " + this.chairs.size() + "/" + SEATS + " occupied seats");
    }

    public Customer getNextCustomer() {
        return this.chairs.isEmpty() ? null : this.chairs.removeLast();
    }

    public synchronized void takeSeat(Customer customer) {
        this.chairs.addFirst(customer);
        this.printCurrentQueue();
    }

    public synchronized ThreadPoolExecutor getExecutor() {
        return this.executor;
    }

    public synchronized Barber getBarber() {
        return this.barber;
    }
}
