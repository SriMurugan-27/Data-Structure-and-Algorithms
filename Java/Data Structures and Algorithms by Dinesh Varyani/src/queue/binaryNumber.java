package queue;

import java.util.Queue;
import java.util.LinkedList;

public class binaryNumber {

    private String[] generateBinaryNumber(int n){
        String[] result = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");

        for(int i = 0; i < n; i++){
            result[i] = q.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            q.offer(n1);
            q.offer(n2);
        }

        return result;
    }

    private void printArray(String[] s){
        for(String str : s){
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        binaryNumber bn = new binaryNumber();
        int input = 10;
        String[] str = bn.generateBinaryNumber(input);
        bn.printArray(str);
    }
}
