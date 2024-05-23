package sort;

public class SelectionSort {

    public void sort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
//            arr[i] = arr[i] + arr[min];
//            arr[min] = arr[i] - arr[min];
//            arr[i] = arr[i] - arr[min];
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 9, 2, 10 };
        SelectionSort ss = new SelectionSort();
        ss.printArray(nums);
        ss.sort(nums);
        ss.printArray(nums);
    }
}
