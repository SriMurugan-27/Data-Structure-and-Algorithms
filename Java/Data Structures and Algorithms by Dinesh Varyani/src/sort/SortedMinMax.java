package sort;

public class SortedMinMax {

    public void arrangeMaxMin(int[] arr){
        int n = arr.length;
        int minIdx = 0;
        int maxIdx = arr.length - 1;
        int max = arr[maxIdx] + 1;

        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                arr[i] = arr[i] + ((arr[maxIdx] % max) * max);
                maxIdx--;
            }else{
                arr[i] = arr[i] + ((arr[minIdx] % max) * max);
                minIdx++;
            }
        }

        for(int i = 0; i < n; i++){
            arr[i] = arr[i] / max;
        }
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6, 8, 9 };
        SortedMinMax smm = new SortedMinMax();
        smm.printArray(arr);
        smm.arrangeMaxMin(arr);
        smm.printArray(arr);
    }
}
