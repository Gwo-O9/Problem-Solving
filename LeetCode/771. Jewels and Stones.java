class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet set = new HashSet<Character>();

        for(int i = 0; i<jewels.length();i++){
            set.add(jewels.charAt(i));
        }
        int count = 0;
        for(int j = 0; j<stones.length();j++){
            if(set.contains(stones.charAt(j))) count++;
        }
        return count;
    }
}
