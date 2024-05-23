package graph;

public class NumberOfIsland {

    public int countIsland(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(visited, i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(boolean[][] visited, int row, int col, int[][] grid){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == '0'){
            return;
        }

        visited[row][col] = true;

        dfs(visited, row, col - 1, grid);   /*GO LEFT*/
        dfs(visited, row - 1, col, grid);   /*GO UP*/
        dfs(visited, row, col + 1, grid);   /*GO RIGHT*/
        dfs(visited, row + 1, col, grid);   /*GO DOWN*/
    }

    public static void main(String[] args) {
        int[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '0', '0', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '1'}
        };

        NumberOfIsland noi = new NumberOfIsland();
        System.out.println(noi.countIsland(grid));
    }
}
