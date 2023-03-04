class Solution {
    public int gcd(int a, int b){
        return a == 0 ? b : gcd(b % a, a);
    }
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<String>();
        if(n == 1) return ans;
        for(int i = 2; i< n+1;i++){
            for(int j = 1; j< i;j++){
                if(gcd(i,j) != 1) continue;
                String temp = new String("");
                temp += Integer.toString(j);
                temp += "/";
                temp += Integer.toString(i);
                ans.add(temp);
            }
        }
        return ans;
    }
}
