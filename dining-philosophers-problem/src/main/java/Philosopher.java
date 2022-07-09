import java.util.concurrent.Callable;

enum State {
    HUNGRY,
    EATING,
    THINKING
}

public class Philosopher implements Callable<Void> {
    private final Table table;
    private final int index;
    private State state = State.THINKING;

    public Philosopher(final Table table, final int index) {
        this.table = table;
        this.index = index;
    }

    public State getState() {
        return this.state;
    }

    /**
     * Become hungry.
     */
    public void setHungry() {
        this.state = State.HUNGRY;
    }

    public void pickUp() {
        if (this.table.canEat(this.index)) {
            this.state = State.EATING;
        }
    }

    public void putDown() {
        this.state = State.THINKING;
    }

    @Override
    public Void call() throws Exception {

        while (true) {
            switch (this.state) {
                case HUNGRY -> this.pickUp();
                case EATING -> {
                    if (Math.floor(Math.random() * 100) > 95) {
                        this.putDown();
                    }
                }
                case THINKING -> {
                    if (Math.floor(Math.random() * 100) > 95) {
                        this.setHungry();
                    }
                }
                default -> throw new IllegalStateException();
            }
            this.table.printTable();
            Thread.sleep(1);
        }
    }
}
