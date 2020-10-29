public class Node {

    // TODO: modify this code to make it a double linked list node

    private int value;   // this stores the value
    private Node next; // this stores the reference to the next node  

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}