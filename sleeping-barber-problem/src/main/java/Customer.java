import java.util.concurrent.Callable;

public class Customer implements Callable<Void> {
    private final int index;
    private final BarberShop barberShop;
    private final Barber barber;

    public Customer(BarberShop barberShop, Barber barber, int index) {
        this.index = index;
        this.barberShop = barberShop;
        this.barber = barber;
    }

    public int getIndex() { return this.index; }

    @Override
    public Void call() {
        if (this.barberShop.isEmpty()) {
            this.barberShop.takeSeat(this);
            this.barber.wakeUp();
        }
        else if (this.barberShop.canSit()) {
            this.barberShop.takeSeat(this);
            System.out.println("Customer " + this.getIndex() + " sat at the barber shop");
        }
        else if (this.barberShop.isFull()) {
            System.out.println("Customer " + this.getIndex() + " could not find a seat and is leaving...");
            return null;
        }
        return null;
    }
}
