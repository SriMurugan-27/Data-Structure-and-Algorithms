package dynamic_programming;

public class Fib_Recursion {

    public static int fib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int left = fib(n - 1);
        int right = fib(n - 2);
        return left + right;
    }

    public static void main(String[] args) {
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(9));
    }

}
