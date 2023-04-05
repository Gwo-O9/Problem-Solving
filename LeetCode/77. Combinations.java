class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        List<Integer> temp = new LinkedList<Integer>();
        helper(ans, temp, n, k, 1);
        return ans;
    }
    public void helper(List<List<Integer>> ans, List<Integer> temp, int n, int k, int i){
        if(temp.size() == k){
            ans.add(new LinkedList<>(temp));
            return;
        }
        for(int j = i;j<=n;j++){
            temp.add(j);
            helper(ans,temp,n,k,j+1);
            temp.remove(temp.size()-1);
        }
    }
}
