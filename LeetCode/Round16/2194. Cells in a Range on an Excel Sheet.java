class Solution {
    public List<String> cellsInRange(String s) {
        List<String> ans = new LinkedList<String>();
        char alp1 = s.charAt(0);
        char alp2 = s.charAt(3);
        char num1 = s.charAt(1);
        char num2 = s.charAt(4);
        for(int i = (int)alp1;i<=(int)alp2;i++){
            for(int j = (int)num1;j<=(int)num2;j++){
                String temp = "";
                temp = temp + (char) i + (char) j;
                ans.add(temp);
            }
        }
        return ans;
    }
}
