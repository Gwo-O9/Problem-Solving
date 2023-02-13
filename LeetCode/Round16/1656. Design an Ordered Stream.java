class OrderedStream {
    String[] temp;
    int ptr;
    public OrderedStream(int n) {
        temp = new String[n];
        int ptr = 0;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<String>();
        temp[idKey-1] = value;
        while(ptr < temp.length && temp[ptr] != null){
            ans.add(temp[ptr]);
            ptr++;
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
