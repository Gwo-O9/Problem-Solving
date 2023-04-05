class MyQueue {

    private Stack<Integer> S = new Stack<>();
    private Stack<Integer> Q = new Stack<>();
    public MyQueue() {} 
    public void push(int x) {
        S.push(x);
    }
    
    public int pop() {
        if(empty()) return -1;
        if(Q.isEmpty()){
            while(!S.isEmpty()){
                Q.push(S.pop());
            }
        }
        return Q.pop();
    }
    
    public int peek() {
        if(empty()) return -1;
        if(Q.isEmpty()){
            while(!S.isEmpty()){
                Q.push(S.pop());
            }
        }
        return Q.peek();
    }
    
    public boolean empty() {
        return S.isEmpty() && Q.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
