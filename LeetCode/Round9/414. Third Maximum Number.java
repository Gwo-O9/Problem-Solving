class Solution {
    public int thirdMax(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;
        int check = 0;
        for(Integer n : nums){
            if (n.equals(first) || n.equals(second) || n.equals(third)) continue;
            if(first == null || n > first){
                Integer temp1 = first;
                Integer temp2 = second;
                first = n;
                second = temp1;
                third = temp2;
                check++;
            }
            else if(second == null || n > second){
                Integer temp3 = second;
                second = n;
                third = temp3;
                check++;
            }
            else if(third == null || n > third){
                third = n;
                check++;
            }
        }
        if(nums.length == 1 || nums.length == 2 || check <= 2) return first;
        else return third;
    }
}
