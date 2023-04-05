class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int count = -1;
        for(int i = 0; i<points.length;i++){
            if(points[i][0] != x && points[i][1] != y) continue;
            else{
                if(min > Math.abs(points[i][0]-x) + Math.abs(points[i][1]-y)) {
                    min = Math.abs(points[i][0]-x) + Math.abs(points[i][1]-y);
                    count = i;
                }
            }
        }
        return count;
    }
}
