class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<Integer> s = new Stack<Integer>();
        int i;
        String operators = "+-/*";
        for(i = 0;i<tokens.length;i++){
            if(operators.contains(tokens[i])){
                int f = s.pop();
                int g = s.pop();
                s.push(cal(tokens[i], g, f));
            }
            else s.push(Integer.parseInt(tokens[i])); 
        }
        return s.pop();
    }
    public int cal(String a, int g, int f){
        if(a.equals("+")) return g + f;
        else if(a.equals("*")) return g*f;
        else if(a.equals("-")) return g-f;
        return g/f;
     }
}
