
public class Node {

    private int data;
    private Node next;

    // Constructor to create a new node
    public Node(int d) {
        data = d;
        next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
