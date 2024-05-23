package algorithms;

public class MaxSumSubArray {

    public static int maxSubArraySum(int[] arr, int k){
        int maxSum = 0;
        int windowSum = 0;
        int start = 0;

        for(int end = 0; end < arr.length; end++){
            windowSum = windowSum + arr[end];
            if(end >= k - 1){
                maxSum = Math.max(maxSum, windowSum);
                windowSum = windowSum - arr[start];
                start++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[] { 2, 7, 3, 5, 8, 1 }, 3));
    }
}
