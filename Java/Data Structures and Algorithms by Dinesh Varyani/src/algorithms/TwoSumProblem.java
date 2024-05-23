package algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    public static int[] twoSum(int[] arr, int target){
        int n = arr.length;
        int[] result = new int[2];
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++){
            if(!m.containsKey(target - arr[i])){
                m.put(arr[i], i);
            }else{
                result[1] = i;
                result[0] = m.get(target - arr[i]);
                return result;
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
        int[] ans = twoSum(arr, 9);
        printArray(ans);
    }
}
