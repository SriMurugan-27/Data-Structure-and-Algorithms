package linkedlist;

public class CircularLinkedList {

    private ListNode last;
    private int length;
    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int value){
            this.data = value;
        }
    }

    public CircularLinkedList(){
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int length(){
        return length;
    }

    public void createCircularLinkedList(){
        ListNode one = new ListNode(1);
        ListNode eight = new ListNode(8);
        ListNode ten = new ListNode(10);
        ListNode sixteen = new ListNode(16);

        one.next = eight;
        eight.next = ten;
        ten.next = sixteen;
        sixteen.next = one;

        last = sixteen;
        length += 4;
    }

    public void display(){
        if(last == null){
            return;
        }

        ListNode first = last.next;
        while(first != last){
            System.out.print(first.data + "-->");
            first = first.next;
        }
        System.out.println(first.data + "-->null");
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if(last == null){
            last = newNode;
        }else{
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(last == null){
            last = newNode;
            last.next = last;
        }else{
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public ListNode removeFirst(){
        if(last == null){
            return null;
        }

        ListNode first = last.next;
        if(last.next == last){
            last = null;
        }else{
            last.next = first.next;
        }
        first.next = null;
        length--;
        return first;
    }

    public ListNode removeLast(){
        if(last == null){
            return null;
        }

        ListNode current = last.next;
        if(last.next == last){
            last = null;
        }else{
            while(current.next != last){
                current = current.next;
            }
            current.next = last.next;
            last.next = null;
        }
        ListNode temp = last;
        last = current;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCircularLinkedList();

        /* Display the Circular LinkedList */
        cll.display();

        /* Insert a Node at the beginning */
        cll.insertFirst(0);
        cll.display();

        /* Insert a Node at the end */
        cll.insertLast(20);
        cll.display();

        /* Remove a Node at the beginning */
        System.out.println(cll.removeFirst().data);
        cll.display();

        /* Remove a Node at the End */
        System.out.println(cll.removeLast().data);
        cll.display();
    }
}
