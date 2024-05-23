package dynamic_programming;

public class TopDown_Approach {

    public static int fib(int[] table,int n){
        if(table[n] == 0){
            if(n < 2){
                table[n] = n;
            }else{
                int left = fib(table, n - 1);
                int right = fib(table, n - 2);
                table[n] = left + right;
            }
        }
        return table[n];
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 5; i++){
            System.out.println(fib(new int[i + 1], i));
        }
    }

}
