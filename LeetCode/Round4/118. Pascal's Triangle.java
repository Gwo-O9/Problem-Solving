class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<List<Integer>>(numRows);
        for(int i = 0; i<numRows;i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0;j<=i;j++){
                if(j == 0 || j == i) temp.add(1);
                else{
                    temp.add(out.get(i-1).get(j-1) + out.get(i-1).get(j));
                }
            }
            out.add(temp);
        }
        return out;
    }
}
