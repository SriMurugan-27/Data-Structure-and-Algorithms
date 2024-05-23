package dynamic_programming;

public class BottomUp_Approach {

    public static int fib(int n){
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;
        for(int i = 2; i <= n; i++){
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++){
            System.out.println(fib(i));
        }
    }
}
