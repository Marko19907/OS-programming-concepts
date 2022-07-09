public class Buffer {
    private final char[] buffer;
    private int count = 0;

    public Buffer(int size) {
        this.buffer = new char[size];
    }

    public synchronized void put(final char c) {
        this.buffer[this.count] = c;
        this.count++;
    }

    /**
     * Returns the last char in the buffer?
     */
    public synchronized char get() {
        final char result = this.buffer[this.count - 1];
        this.count--;
        return result;
    }

    public synchronized boolean isEmpty() {
        return this.count == 0;
    }

    public synchronized boolean isFull() {
        return this.count == this.buffer.length;
    }
}
