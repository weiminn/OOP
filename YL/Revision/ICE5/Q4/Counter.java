public abstract class Counter {
    private int value;
    protected Counter(int value) {
        this.value = value;
    }
    
    public abstract void decrement();

    public abstract void increment();

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
