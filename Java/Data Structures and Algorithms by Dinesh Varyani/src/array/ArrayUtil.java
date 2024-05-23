package array;

public class ArrayUtil {

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] reverseArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return arr;
    }

    public int findMinimum(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int val : nums){
            if(val < min){
                min = val;
            }
        }
        return min;
    }

    public int findSecondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j > secondMax && j != max) {
                secondMax = j;
            }
        }

        return secondMax;
    }

    public void moveZeros(int[] arr){
        int j = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
        }
    }

    public int[] resize(int[] arr, int capacity){
        int[] temp = new int[capacity];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
        return arr;
    }

    public int missingNumber(int[] arr){
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for(int val : arr){
            sum -= val;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayUtil arrUtil = new ArrayUtil();

        /* Display a array */
        int[] arr = { 5, 1, 9, 2, 10 };
        arrUtil.printArray(arr);

        /* Reverse a Array */
        int[] result = arrUtil.reverseArray(arr);
        arrUtil.printArray(result);

        /* Find the Minimum element in a Array */
        int[] nums = { 5, 9, 3, 15, 1, 2 };
        arrUtil.printArray(nums);
        System.out.println(arrUtil.findMinimum(nums));

        /* Find Second Max number in a Array*/
        int[] arr1 = { 12, 34, 2, 34, 33, 1 };
        arrUtil.printArray(arr1);
        System.out.println(arrUtil.findSecondMax(arr1));

        /* Move all Zero's to end of the array */
        int[] arr2 = { 0, 1, 0, 4, 12 };
        arrUtil.printArray(arr2);
        arrUtil.moveZeros(arr2);
        arrUtil.printArray(arr2);

        /* Resize the array */
        int[] resize = { 5, 9, 3, 10 };
        arrUtil.printArray(resize);
        int[] res = arrUtil.resize(resize, arr.length * 2);
        arrUtil.printArray(res);

        /* Missing number in a array */
        int[] missing = { 2, 4, 1, 8, 6, 3, 7 };
        arrUtil.printArray(missing);
        System.out.println(arrUtil.missingNumber(missing));

    }

}
