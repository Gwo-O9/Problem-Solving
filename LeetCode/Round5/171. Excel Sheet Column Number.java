class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int sum = 0;
        
        for(int i = 0;i<n;i++){
            sum += (columnTitle.charAt(i)-64)*Math.pow(26,n-i-1);
        }
        return sum;
    }
}
