package algorithms;

public class MaximumSum {

    public static int maxSubArraySum(int[] arr){
        int n = arr.length;
        int maxSoFar = arr[0];
        int currentMax = arr[0];

        for(int i = 1; i < n; i++){
            currentMax = currentMax + arr[i];
            if(currentMax < arr[i]){
                currentMax = arr[i];
            }
            if(maxSoFar < currentMax){
                maxSoFar = currentMax;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, -2, 6, -12, 7, -1, 6 };
        System.out.println(maxSubArraySum(arr));
    }
}
