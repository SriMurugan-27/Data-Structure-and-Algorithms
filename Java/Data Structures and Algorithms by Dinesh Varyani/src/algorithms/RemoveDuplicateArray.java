package algorithms;

import java.util.Arrays;

public class RemoveDuplicateArray {

    public static int removeDuplicate(int[] num){
        Arrays.sort(num);
        int j = 1;

        for(int i = 1; i < num.length; i++){
            if(num[i] != num[i - 1]){
                num[j] = num[i];
                j++;
            }
        }

        printArray(num);

        return j;
    }

    private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicate(new int[] { 1, 2, 1 }));
        System.out.println(removeDuplicate(new int[] { 2, 2, 3, 4, 3, 1, 1, 0, 1, 0}));
    }
}
