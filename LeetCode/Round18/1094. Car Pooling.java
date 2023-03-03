class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] move = new int[1001];
        for(int i = 0; i<trips.length;i++){
            move[trips[i][1]] += trips[i][0];
            move[trips[i][2]] -= trips[i][0]; 
        }
        int tracking = 0;
        for(int j = 0; j<1001;j++){
            tracking += move[j];
            if(tracking > capacity) return false;
        }
        return true;
    }
}
