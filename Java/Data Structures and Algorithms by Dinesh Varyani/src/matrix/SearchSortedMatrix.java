package matrix;

public class SearchSortedMatrix {

    private void searchMatrix(int[][] matrix, int x){
        int n = matrix.length;
        int i = 0;
        int j = n - 1;

        while(i < n && j >= 0){
            if(matrix[i][j] == x){
                System.out.println(x + " is found in " + ++i + " row and " + ++j + " columns");
            }
            if(matrix[i][j] > x){
                j--;
            }else{
                i++;
            }
        }

        System.out.println("not found!!!");
    }

    public static void main(String[] args) {
        int[][] m = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };

        SearchSortedMatrix ssm = new SearchSortedMatrix();
        ssm.searchMatrix(m, 35);
    }
}
