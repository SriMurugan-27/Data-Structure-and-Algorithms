package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SlidingWindowMaximum {

    public static List<Integer> maxSlidingWindow(int[] arr, int k){
        int[] ngeArr = nextGreaterIndex(arr);
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i <= arr.length - k; i++){
            int j = i;

            while(ngeArr[j] < i + k){
                j = ngeArr[j];
            }

            result.add(arr[j]);
        }

        return result;
    }

    private static int[] nextGreaterIndex(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                result[i] = arr.length;
            }else{
                result[i] = stack.peek();
            }

            stack.push(i);
        }

        return result;
    }

    public static void printList(List<Integer> list){
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> ans = maxSlidingWindow(new int[] { 44, 77, 33, 44, 88, 11 }, 3);
        printList(ans);
    }
}
