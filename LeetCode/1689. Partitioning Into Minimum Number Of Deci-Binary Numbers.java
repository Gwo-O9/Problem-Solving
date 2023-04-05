class Solution {
    public int minPartitions(String n) {
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n.length();i++){
            max = Math.max(max,(int)(n.charAt(i)-48));
        }
        return max;
    }
}
