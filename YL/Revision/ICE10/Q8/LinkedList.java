public class LinkedList {

    Node head;
    Node tail;
    int size;

    public LinkedList() {
        super();
    }

    public void add(int element) {
        Node nN = new Node(element);
        if(head == null || tail == null){
            head = nN;
            tail = nN;
        } else {
            nN.setPrev(tail);
            tail.setNext(nN);
            tail = nN;
        }
        size++;

    }

    public void add(int position, int element) {
        if(size > 0){
            int i = 0;
            Node _n = head;
            while (i < position) {
                _n = _n.getNext();
                i++;
            }
            Node prev = _n.getPrev();
            Node newNode = new Node(element);
    
            newNode.setNext(_n);
            _n.setPrev(newNode);
    
            if(prev != null){
                prev.setNext(newNode);
                newNode.setPrev(prev);
            } else {
                head = newNode;
            }
            size++;
        } else {
            add(element);
        }
        

    }

    public void remove() {
        head = head.getNext();
        head.setPrev(null);

        size--;
    }

    public void remove(int position) {
        if(size > 0){
            int i = 0;
            Node _n = head;
            while (i < position) {
                _n = _n.getNext();
                i++;
            }

            Node prev = _n.getPrev();
            Node next = _n.getNext();

            if(prev != null & next != null) {prev.setNext(next);}
            else if(next == null) {
                prev.setNext(null);
                tail = prev;
            }
            else if(prev == null) {
                next.setPrev(null);
                head = next;
            }
            size--;
        } else {
            remove();
        }

    }

    public int size() {
        return size;
        
    }

    public void print(){
        System.out.println();
        int i = 0;
        Node _n = head;
        while (_n != null) {
            System.out.print(_n.getValue() + " ");
            _n = _n.getNext();
        }

    }
    
}
