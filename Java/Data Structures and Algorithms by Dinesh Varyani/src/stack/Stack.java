package stack;

import java.util.EmptyStackException;

public class Stack {

    private ListNode top;
    private int length;
    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int value){
            this.data = value;
        }
    }

    public Stack(){
        this.top = null;
        this.length = 0;
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int val){
        ListNode newNode = new ListNode(val);
        newNode.next = top;
        top = newNode;
        length++;
    }

    public int peek(){
        return top.data;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public void diplay(){
        ListNode temp = top;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        stack.push(3);
        stack.push(4);
        stack.diplay();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }


}
