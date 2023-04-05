class Solution {
    public int romanToInt(String s) {
        int I = 1;
        int V = 5;
        int X = 10;
        int L = 50;
        int C = 100;
        int D = 500;
        int M = 1000;
        int n = s.length();
        int sum = 0;
        
        for(int i = 0; i<n;i++){
            if(i == n) break;
            if(i == n-1){
                if(s.charAt(i) == 'I') sum+= I;
                if(s.charAt(i) == 'V') sum+= V;
                if(s.charAt(i) == 'X') sum+= X;
                if(s.charAt(i) == 'L') sum+= L;
                if(s.charAt(i) == 'C') sum+= C;
                if(s.charAt(i) == 'D') sum+= D;
                if(s.charAt(i) == 'M') sum+= M;
                break;
            } 
            if(s.charAt(i) == 'I' && s.charAt(i+1) != 'V' && s.charAt(i+1) != 'X') sum += I;
            else if(s.charAt(i) == 'I' && s.charAt(i+1) == 'V'){
                sum+= 4;
                i++;
            }
            else if(s.charAt(i) == 'I' && s.charAt(i+1) == 'X'){
                sum+= 9;
                i++;
            }
            else if(s.charAt(i) == 'V') sum += V;
            else if(s.charAt(i) == 'X' && s.charAt(i+1) != 'L' && s.charAt(i+1) != 'C') sum += X;
            else if(s.charAt(i) == 'X' && s.charAt(i+1) == 'L'){
                sum+= 40;
                i++;
            }
            else if(s.charAt(i) == 'X' && s.charAt(i+1) == 'C'){
                sum+= 90;
                i++;
            }
            else if(s.charAt(i) == 'L') sum += L;
            else if(s.charAt(i) == 'C' && s.charAt(i+1) != 'D' && s.charAt(i+1) != 'M') sum += C;
            else if(s.charAt(i) == 'C' && s.charAt(i+1) == 'D'){
                sum += 400;
                i++;
            }
            else if(s.charAt(i) == 'C' && s.charAt(i+1) == 'M'){
                sum += 900;
                i++;
            }
            else if(s.charAt(i) == 'D') sum += D;
            else if(s.charAt(i) == 'M') sum += M;
        }
        return sum;
    }
}
