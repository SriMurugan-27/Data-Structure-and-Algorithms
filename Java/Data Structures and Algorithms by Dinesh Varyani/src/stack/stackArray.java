package stack;

import java.util.EmptyStackException;

public class stackArray {
    private int[] stack;
    private int top;

    public stackArray(int capacity){
        this.stack = new int[capacity];
        this.top = -1;
    }

    public stackArray(){
        this(10);
    }

    public boolean isFull(){
        return stack.length == size();
    }

    public int size(){
        return top++;
    }

    public void push(int value){
        if(isFull()){
            throw new RuntimeException("Stack is Full");
        }

        top++;
        stack[top] = value;
    }

    public int peek(){
        return stack[top];
    }

    public boolean isEmpty(){
        return stack.length == 0;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        int result = stack[top];
        top--;
        return result;
    }

    public void display(){
        for(int i = 0; i <= top; i++){
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        System.out.println(s.peek());
        s.push(3);
        s.push(4);
        s.diplay();

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }


}
