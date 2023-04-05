class Solution {
    public boolean isValidSudoku(char[][] board) {
        int i,j,k;
        for(i = 0; i<9;i++){
            HashSet set = new HashSet<Character>();
            for(j = 0; j<9;j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }
        }
        for(i = 0; i<9;i++){
            HashSet set2 = new HashSet<Character>();
            for(j = 0; j<9;j++){
                if(board[j][i] == '.') continue;
                if(set2.contains(board[j][i])) return false;
                else set2.add(board[j][i]);
            }
        }
        for(i = 0;i<9;i += 3){
            for(int t = 0; t<9; t += 3){
                HashSet set3 = new HashSet<Character>();
                for(j = i;j<i+3;j++){
                    for(k = t;k<t+3;k++){
                        if(board[j][k] == '.') continue;
                        if(set3.contains(board[j][k])) return false;
                        else set3.add(board[j][k]);
                    }
                }
            }
        }
        return true;
    }
}
