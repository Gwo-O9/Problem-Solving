class Solution {
    public String interpret(String command) {
        String ans = new String("");
        for(int i = 0; i<command.length();i++){
            if(command.charAt(i) == 'G') ans += "G";
            if(command.charAt(i) == '('){
                if(command.charAt(i+1) == ')') ans += "o";
                else ans = ans + "a" + "l";
            }
        }
        return ans;
    }
}
