class Solution {
    public double average(int[] salary) {
        double ans = 0;
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        for(int i = 0; i<salary.length;i++){
            ans += salary[i];
            if(salary[i] > max) max = salary[i];
            if(salary[i] < min) min = salary[i];
        }
        ans -= (max + min);
        return ans/(salary.length-2);
    }
}
