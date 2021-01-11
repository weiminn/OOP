public class ReverseTest {

    public static void main(String[] args) {

        Node prev = null;
        Node head = null;
        for (int i = 1; i <= 10; i++) {
            head = new Node(i);
            head.setNext(prev);
            prev = head;
        }

        // LinkedListUtility.print(head);
        head = LinkedListUtility.reverse(head);
        System.out.println("-- Testing reverse --");
        System.out.println("Expected: ");
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null");
        System.out.println("Actual:");
        LinkedListUtility.print(head);


    }
}
