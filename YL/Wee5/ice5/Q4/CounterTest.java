public class CounterTest {
    public static void main(String[] args) {

        System.out.println("Testing CircularCounter: ");
        CircularCounter circularCounter = new CircularCounter(5);

        // call increment 20 times
        for (int i = 0; i < 20; i++) {
            circularCounter.increment();
            System.out.print(circularCounter.getValue() + ", ");
        }

        System.out.println();
        System.out.println();
        System.out.println("Testing MinMaxCounter (incrementing): ");
        MinMaxCounter minMaxCounter = new MinMaxCounter(2, 5);
        for (int i = 0; i < 10; i++) {
            minMaxCounter.increment();
            System.out.print(minMaxCounter.getValue() + ", ");
        }
        System.out.println();
        System.out.println("Testing MinMaxCounter (decrementing): ");
        for (int i = 0; i < 10; i++) {
            minMaxCounter.decrement();
            System.out.print(minMaxCounter.getValue() + ", ");
        }



    }
}