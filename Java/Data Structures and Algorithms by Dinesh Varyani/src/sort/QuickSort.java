package sort;

public class QuickSort {

    public void sort(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            sort(arr,low, p - 1);
            sort(arr, p + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high){
        int n = arr.length;
        int pivot = arr[high];
        int i = 0;
        int j = 0;

        while(i < n){
            if(arr[i] <= pivot){
/*                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];*/
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }

        return j - 1;
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };
        QuickSort qs = new QuickSort();
        qs.printArray(arr);
        qs.sort(arr, 0, arr.length - 1);
        qs.printArray(arr);
    }
}
