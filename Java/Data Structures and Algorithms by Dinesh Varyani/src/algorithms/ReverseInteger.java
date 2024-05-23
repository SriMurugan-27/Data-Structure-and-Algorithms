package algorithms;

public class ReverseInteger {

    public static long reverse(int number){
        boolean isNegative = number < 0;
        if(isNegative) number *= -1;
        long reverse = 0;

        while(number > 0){
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number /= 10;
        }

        return isNegative ? reverse * -1 : reverse;
    }

    public static void main(String[] args) {
        int[] num = { 1234, -1234, 2147483647 };

        for(int n : num){
            System.out.println(reverse(n));
        }
    }
}
