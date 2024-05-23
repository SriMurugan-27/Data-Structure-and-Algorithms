package stack;

import java.util.Stack;
public class nextGreater {

    private int[] nextGreaterElements(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && arr[i] >= stack.peek()){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
            }else{
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return result;
    }

    public void printArray(int[] arr){
        for(int val : arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = { 4, 7, 3, 4, 8, 4 };
        nextGreater nge = new nextGreater();
        nge.printArray(nums);

        int[] ans = nge.nextGreaterElements(nums);
        nge.printArray(ans);
    }
}
