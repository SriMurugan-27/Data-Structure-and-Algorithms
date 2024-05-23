package sort;

public class BubbleSort {

    public void sort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            boolean isSwapped = false;
            for(int j = 0; j < n - 1 - j; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped) break;
        }
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 2, 9, 10 };
        BubbleSort bs = new BubbleSort();
        bs.printArray(arr);
        bs.sort(arr);
        bs.printArray(arr);
    }
}
