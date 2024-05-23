package sort;

public class InsertionSort {

    public void sort(int[] arr){
        int n = arr.length;
        for(int i = 0;  i < n; i++){
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 2, 9, 10 };
        InsertionSort is = new InsertionSort();
        is.printArray(nums);
        is.sort(nums);
        is.printArray(nums);
    }
}
