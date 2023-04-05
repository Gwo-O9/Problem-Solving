class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack();
        int n = operations.length;
        int a = 0;
        int b = 0;
        int c = 0;
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(operations[i].charAt(0) == '+'){
                a = s.pop();
                b = s.pop();
                c = a + b;
                s.push(b);
                s.push(a);
                s.push(c);
            }
            else if(operations[i].charAt(0) == 'D'){
                a = s.pop();
                s.push(a);
                s.push(a*2);
            }
            else if(operations[i].charAt(0) == 'C'){
                s.pop();
            }
            else{
                s.push(Integer.parseInt(operations[i]));
            }
        }
        while(!s.isEmpty()){
            ans += s.pop();   
        }
        return ans;
    }
}
