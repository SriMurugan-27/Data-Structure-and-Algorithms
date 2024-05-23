package sort;

public class DutchNationalFlag {

    public void sort(int[] arr){
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while(i <= k){
            if(arr[i] == 0){
                swap(arr ,i, j);
                i++; j++;
            } else if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, k);
                k--;
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 2, 0, 1, 2 };
        DutchNationalFlag dnf = new DutchNationalFlag();
        dnf.printArray(nums);
        dnf.sort(nums);
        dnf.printArray(nums);
    }
}
