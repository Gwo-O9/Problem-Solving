class MyStack {

    private Queue<Integer> S = new LinkedList<>();
    public MyStack() {}
    
    public void push(int x) {
        S.add(x);
    }
    
    public int pop() {
        if(empty()) return -1;
        int i = 0;
        int n = S.size();
        while(i < S.size()-1){
                S.add(S.poll());
                i++;
        }
        return S.poll();
    }
    
    public int top() {
        if(empty()) return -1;
        int i = 0;
        int n = S.size();
        while(i< S.size()-1){
            S.add(S.poll());
            i++;
        }
        int ans = S.peek();
        S.add(S.poll());
        return ans;
    }
    
    public boolean empty() {
        if(S.isEmpty()) return true;
        else return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
