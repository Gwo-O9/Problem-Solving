class Solution {
    public boolean isHappy(int n) {
        int temp;
        String tmp;
        while(true){
            if(n == 1) return true;
            if(n > 1 && n < 7) return false;
            temp = 0;
            tmp = String.valueOf(n);
            for(int i = 0;i<tmp.length();i++){
                int a = tmp.charAt(i);
                temp += Math.pow(a-48,2);
            }
            n = temp;
        }
    }
}
