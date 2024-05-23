package linkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;
    private class ListNode{
        private int data;
        private ListNode previous;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.previous = null;
            this.next = null;
            size++;
        }
    }

    public DoublyLinkedList(){
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void createLinkedList(){
        ListNode one = new ListNode(1);
        ListNode ten = new ListNode(10);
        ListNode fifteen = new ListNode(15);
        ListNode sixtyfive = new ListNode(65);

        head = one;
        one.next = ten;
        ten.previous = one;
        ten.next = fifteen;
        fifteen.previous = ten;
        fifteen.next = sixtyfive;
        sixtyfive.previous = fifteen;
        tail = sixtyfive;

    }

    public void displayForward(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        ListNode current = tail;
        while(current != null){
            System.out.print(current.data + "-->");
            current = current.previous;
        }
        System.out.println("null");
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail = newNode;
        }else{
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
    }

    public ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Invalid Command!");
        }

        ListNode temp = head;
        head = head.next;
        head.previous = null;
        temp.next = null;
        return temp;
    }

    public ListNode deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException("Invalid Command!");
        }

        ListNode temp = tail;
        tail = tail.previous;
        tail.next = null;
        temp.previous = null;
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        System.out.println(dll.isEmpty());

        dll.createLinkedList();

        System.out.println(dll.isEmpty());

        /* Display the Double LinkedList */
        dll.displayForward();
        dll.displayBackward();

        /* Insert a element at the beginning */
        dll.insertFirst(0);
        dll.displayForward();

        /* Insert a element at the end */
        dll.insertLast(85);
        dll.displayBackward();

        /* Delete element at the beginning */
        System.out.println(dll.deleteFirst().data);
        dll.displayForward();

        /* Delete element ar the end */
        System.out.println(dll.deleteLast().data);
        dll.displayBackward();
    }
}
