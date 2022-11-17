class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> out = new ArrayList<List<Integer>>(rowIndex+1);
        for(int i = 0; i<rowIndex+1;i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0;j<=i;j++){
                if(j == 0 || j == i) temp.add(1);
                else{
                    temp.add(out.get(i-1).get(j-1) + out.get(i-1).get(j));
                }
            }
            out.add(temp);
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i<=rowIndex;i++){
            result.add(out.get(rowIndex).get(i));
        }
        return result;
    }
}
