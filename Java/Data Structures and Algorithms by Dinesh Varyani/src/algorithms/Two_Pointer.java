package algorithms;

import java.util.Arrays;

public class Two_Pointer {

    public static int[] findPairs(int[] arr, int target){
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int[] result = new int[2];

        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                result[0] = arr[left];
                result[1] = arr[right];
                return result;
            }
            if(sum < target){
                left++;
            }else{
                right--;
            }
        }

        return result;
    }

    public static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 2, 11, 5, 10, 7, 8 };
        printArray(arr);
        int[] ans = findPairs(arr, 9);
        printArray(ans);
    }
}
