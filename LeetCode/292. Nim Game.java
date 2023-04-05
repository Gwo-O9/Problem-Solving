class Solution {
    public boolean canWinNim(int n) {
        if(n == 1 || n == 2 || n == 3) return true;
        if(n == 4 || n <= 0) return false;
        if(canWinNim(n-1) && canWinNim(n-2) && canWinNim(n-3)) return false;
        return true;
    }
}

/* Note: if n%4 = 0, it is false. so we can write the code in one line
return n%4 == 0 ? false : true; */
