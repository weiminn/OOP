public class MinMaxCounter extends Counter{
    private int min;
    private int max;

    public MinMaxCounter(int min, int max) {
        super(min);
        this.min = min;
        this.max = max;
    }
    
    @Override
    public void increment() {
        if(getValue() < max) setValue(getValue()+1);
    }

    @Override
    public void decrement() {
        if(getValue() > min) setValue(getValue()-1);
    }
    
}
