class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        int i = 0;
        int j;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for(; i<n1; i++){
            arr1[n1-i-1] = num1.charAt(i) - 48;
        }
        for(i = 0; i<n2; i++){
            arr2[n2-i-1] = num2.charAt(i) - 48;
        }
        int maxn = n1 + n2 + 1;
        int[] output = new int[maxn];
        for(i = 0; i<n1; i++){
            for(j = 0; j<n2; j++){
                int temp = arr1[i]*arr2[j];
                output[i+j] += temp;
            }
        }
        for(i = 0; i<maxn-1;i++){
            int temp = output[i]/10;
            output[i] = output[i]%10;
            if(i+1 == maxn -1) break;
            output[i+1] += temp;
        }
        String ans = new String("");
        int t = 0;
        while(output[maxn-t-1] <= 0){
            t++;
        }
        while(t<maxn){
            ans += output[maxn-t-1];
            t++;
        }
        return ans;
    }
}
