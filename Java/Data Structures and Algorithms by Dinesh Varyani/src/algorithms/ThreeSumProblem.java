package algorithms;

import java.util.Arrays;

public class ThreeSumProblem {

    public static void threeSum(int[] arr, int target){
        Arrays.sort(arr);

        for(int i =  0; i < arr.length; i++){
            int j = i + 1;
            int k = arr.length - 1;

            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target){
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    j++;
                    k--;
                }else if(sum < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        threeSum(new int[] { 2, 4, 3, 7, 1, 8, 9, 0 }, 6);
    }
}
