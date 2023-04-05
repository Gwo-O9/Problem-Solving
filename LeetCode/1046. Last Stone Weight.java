class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int n = stones.length;
        for(int i = 0; i<n;i++){
            pQ.offer(stones[i]);
        }
        while(pQ.size() > 1){
            int s1 = pQ.poll();
            int s2 = pQ.poll();
            if(s1 != s2) pQ.offer(s1-s2);
        }
        if(pQ.isEmpty()) return 0;
        else return pQ.poll();
    }
}
