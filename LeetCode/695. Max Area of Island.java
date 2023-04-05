class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int max = 0;
        for(int i = 0; i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    max = Math.max(search(grid, i, j), max);
                }
            }
        }
        return max;
    }

    public int search (int[][] grid, int i, int j){
         if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int sum = 1;
        grid[i][j] = 0;
        if(i < grid.length-1){
            if(grid[i+1][j] == 1){
                sum += search(grid, i+1, j);
            }
        }
        if(i > 0){
            if(grid[i-1][j] == 1){
                sum += search(grid, i-1, j);
            }
        }
        if(j < grid[0].length-1){
            if(grid[i][j+1] == 1) {
                sum += search(grid, i, j+1);
            }
        }
        if(j > 0){
            if(grid[i][j-1] == 1){
                sum += search(grid, i, j-1);
            }
        }
        return sum;
    }
}
