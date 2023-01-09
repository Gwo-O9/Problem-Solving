class Solution {
    public boolean isAlienSorted(String[] words, String order){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i,j;
        for(i = 0; i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        for(i = 1;i<words.length;i++){
            int n = Math.max(words[i].length(), words[i-1].length());
            int count = 0;
            for(j = 0; j<n;j++){
                if(j == words[i-1].length()) break;
                else if(j == words[i].length()){
                    if(count == j) return false;
                    else break;
                }
                int front = map.get(words[i].charAt(j));
                int back = map.get(words[i-1].charAt(j));
                if(front > back) break;
                if(front < back) return false;
                if(front == back) count++;
            }
        }
        return true;
    }
}
