public class App {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);

        ll.print();

        ll.add(1, 11);

        ll.print();

        ll.remove(2);

        ll.print();

        ll.remove();

        ll.print();


    }
    
}
