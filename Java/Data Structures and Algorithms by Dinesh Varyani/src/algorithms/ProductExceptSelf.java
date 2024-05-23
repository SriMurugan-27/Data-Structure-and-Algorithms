package algorithms;

public class ProductExceptSelf {

    public static int[] findProduct(int[] arr){
        int temp = 1;
        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            result[i] = temp;
            temp = temp * arr[i];
        }

        temp = 1;
        for(int i = arr.length - 1; i >= 0; i--){
            result[i] = result[i] * temp;
            temp = temp * arr[i];
        }

        return result;
    }

    private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { -1, 1, 0, -3, 3 }
        };

        for (int[] a : arr){
            printArray(a);
            printArray(findProduct(a));
        }
    }

}
