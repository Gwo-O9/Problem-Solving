class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int len = num.length;
        List<Integer> ans = new LinkedList<Integer>();
        for(int i = 0;i<len;i++){
            k += num[len-1-i];
            ans.add(k%10);
            k = k/10;
        }
        while(k > 0){
            ans.add(k%10);
            k = k/10;
        }
        List<Integer> out = new LinkedList<Integer>();
        for(int j = 0; j<ans.size();j++){
            out.add(ans.get(ans.size()-j-1));
        }
        return out;
    }
}
