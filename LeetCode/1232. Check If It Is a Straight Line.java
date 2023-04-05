class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) return true;
        int a = coordinates[0][0] - coordinates[1][0];
        int b = coordinates[1][1] - coordinates[0][1];
        int c = b*coordinates[0][0] + a*coordinates[0][1];
        for(int i = 2; i<coordinates.length;i++){
            if(b*coordinates[i][0] + a*coordinates[i][1] != c) return false;
        } 
        return true;
    }
}
