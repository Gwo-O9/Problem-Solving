/**
 * @param {number[]} nums
 * @return {number}
 */
var findNumbers = function(nums) {
    var cnt = 0;
    for(let i = 0;i<nums.length;i++){
        let temp = nums[i].toString();
        if(temp.length%2 == 0) cnt++;
    }
    return cnt;
};
