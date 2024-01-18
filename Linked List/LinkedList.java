public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        //Step-1 => Create a new node.
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        //Step-2 => newNode next = head
        newNode.next = head;

        //Step-3 => head = newNode
        head = newNode;
    }
       
    public void addLast(int data) {
        // Step-1 => Create a new node.
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step-2 => tail.next = newNode
        tail.next = newNode;

        // Step-3 => tail = newNode
        tail = newNode;
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        int i = 0;
        Node temp = head;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // i == idx-1 && temp = previous
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LinkedList is Empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        //prev : i = size-2
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        // temp = previous
        int val = temp.next.data; //tail.data
        temp.next = null;
        tail = temp;
        size--;
        return val;

    }

    public void print() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int itrSearch(int key) { //iterative search (returning the index where the data is found, otherwise -1)
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //slow is the midNode
    }

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;
        while (fast == null && fast.next == null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if (slow == fast) {
                return true; // cycle exists
            }
        }
        return false; // cycle doesn't exist
    }

    public static void removeCycle() {
        // Step-1 : detect cycle
        // Step-2 : find last node
        // Step-3 : remove cycle -> last.next = null

        // Step-1 : detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        
        // Step-2 : find last node
        Node lastNode = null;
        while (slow != fast) {
            lastNode = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Step-3 : remove cycle -> last.next = null
        lastNode.next = null;
    }
    
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
        ll.add(2, 0);
        ll.print();
        System.out.println(ll.size);
        ll.removeFirst();
        ll.print();
        System.out.println(ll.size);
        ll.removeLast();
        ll.print();
        System.out.println(ll.size);
        System.out.println(ll.itrSearch(0));
        System.out.println(ll.itrSearch(10));
    }
    
    
}