public class InterleaveTest {
    public static void main(String[] args) {

        Node prev = null;
        Node head = null;
        for (int i = 1; i <= 10; i++) {
            head = new Node(i);
            head.setNext(prev);
            prev = head;
        }

        // LinkedListUtility.print(head);
        System.out.println("-- Testing interleave --");
        System.out.println("Expected: ");
        System.out.println("10 -> 1 -> 9 -> 2 -> 8 -> 3 -> 7 -> 4 -> 6 -> 5 -> null");
        LinkedListUtility.interleave(head);
        System.out.println("Actual:");
        LinkedListUtility.print(head);


    }
}
