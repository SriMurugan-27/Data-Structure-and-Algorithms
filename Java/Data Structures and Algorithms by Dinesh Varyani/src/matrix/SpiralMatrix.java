package matrix;

public class SpiralMatrix {

    public void spiralMaxtrix(int[][] m, int r, int c){
        int  k = 0, l= 0;

        while(k < r && l < c){
            for(int i = k; i < c; i++){
                System.out.print(m[k][i] + " ");
            }
            k++;

            for(int i = k; i < r; i++){
                System.out.print(m[i][c - 1] + " ");
            }
            c--;

            if(k < r){
                for(int i = c - 1; i >= l ; i--){
                    System.out.print(m[r - 1][i] + " ");
                }
                r--;
            }

            if(l < c){
                for(int i = r - 1; i >= k; i--){
                    System.out.print(m[i][l] + " ");
                }
                l++;
            }
        }

    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        SpiralMatrix sm = new SpiralMatrix();
        sm.spiralMaxtrix(m, m.length,m[0].length);
    }
}
