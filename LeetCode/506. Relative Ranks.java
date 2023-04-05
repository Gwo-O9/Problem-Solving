class Solution {
    public String[] findRelativeRanks(int[] score){
        int n = score.length;
        int[] sortscore = new int[n];
        String[] rank = new String[n];
        String[] output = new String[n];
        
        for(int i = 0;i<n;i++){
            sortscore[i] = score[i];
        }
        Arrays.sort(sortscore);
        
        switch(n){
            case 1: rank[0] = "Gold Medal";
                break;
            case 2: rank[1] = "Gold Medal";
                    rank[0] = "Silver Medal";
                break;
            default: rank[n-1] = "Gold Medal";
                     rank[n-2] = "Silver Medal";
                     rank[n-3] = "Bronze Medal";
                break;
        }
        
        for(int i = n-4, k = 4; i>=0;i--,k++){
            rank[i] = String.valueOf(k);
        }
        
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                if(score[i] == sortscore[j]) output[i] = rank[j];
            }
        }
        return output;
    }
}
