public class LinkedListUtility {
    public static void print(Node head) {
        Node ptr = head;
        if (ptr == null) {
            System.out.println(ptr);
        }

        String output = "";
        while (ptr != null) {
            output += ptr.getData() + " -> ";
            ptr = ptr.getNext();
        }


        System.out.println(output + "null");
    }


}
