class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int i;
        int max = Integer.MIN_VALUE;
        for(i = 0; i< candies.length;i++){
            if(max < candies[i]) max = candies[i];
        }
        List<Boolean> ans = new ArrayList<Boolean>();
        for(i = 0; i < candies.length;i++){
            int sum = candies[i] + extraCandies;
            if(sum >= max){
                ans.add(true);
            }
            else ans.add(false);
        }
        return ans;
    }
}
