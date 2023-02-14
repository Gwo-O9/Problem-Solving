/**
 * @param {number[][]} grid
 * @return {number[][]}
 */
var largestLocal = function(grid) {
    let n = grid.length
    const ans = [];
    for(let i = 0; i< n-2;i++){
        let temp = [];
        for(let j = 0;j<n-2;j++){
            temp.push(Math.max(
                grid[i][j], grid[i][j + 1], grid[i][j + 2],
                grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
                grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2]
            ))
        }
        ans.push(temp);
    }
    return ans;
};
