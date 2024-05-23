package algorithms;

public class RemoveElement {

    public static int swap(int[] arr, int val){
        int j = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != val){
                arr[j] = arr[i];
                j++;
            }
        }

        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        return j;
    }

    public static void main(String[] args) {
        System.out.println(swap(new int[] { 3, 2, 2, 3}, 3));
        System.out.println(swap(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
    }
}
