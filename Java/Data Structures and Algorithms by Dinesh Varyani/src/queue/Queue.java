package queue;

import java.util.NoSuchElementException;

public class Queue {


    private ListNode front;
    private ListNode rear;
    private int length;
    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int value){
            this.data = value;
            this.next = null;
        }
    }

    public Queue(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void offer(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            front = newNode;
        }else{
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    public int poll(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        int result = front.data;
        front = front.next;
        length--;
        return result;
    }

    public void display(){
        ListNode temp = front;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.display();

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
