package sort;

public class MergeSortedArrays {

    private int[] merge(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[n + m];

        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                ans[k] = arr1[i];
                i++;
            }else {
                ans[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i < n){
            ans[k] = arr1[i];
            i++; k++;
        }

        while(j < m){
            ans[k] = arr2[j];
            j++; k++;
        }

        return ans;
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 5, 10 };
        int[] b = { 4, 6, 11, 15 };
        MergeSortedArrays msa = new MergeSortedArrays();
        msa.printArray(a);
        msa.printArray(b);
        int[] result = msa.merge(a,b);
        msa.printArray(result);
    }

}
