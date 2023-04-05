class Solution {
    public int countOperations(int num1, int num2) {
        if(num1 == 0 || num2 == 0) return 0;
        if(num1 == num2) return 1;
        int cnt = 0;
        while(true){
            cnt++;
            if(num1 > num2){
                num1 = num1 - num2;
            }
            else if(num1 < num2){
                num2 = num2 - num1;
            }
            else{
                return cnt;
            }
        }
    }
}
