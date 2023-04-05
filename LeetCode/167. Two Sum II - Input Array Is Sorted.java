class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int j = numbers.length;
        for(int i = 0; i<numbers.length-1;i++){
            int left = i;
            int right = numbers.length-1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(numbers[i] + numbers[mid] == target){
                    if(mid == i){
                        ans[0] = i+1;
                        ans[1] = i+2;
                        return ans;
                    }
                    ans[0] = i+1;
                    ans[1] = mid+1;
                    return ans;
                }
                else if(numbers[i] + numbers[mid] > target) right = mid-1;
                else left = mid+1;
            }
        }
        return ans;
    }
}
