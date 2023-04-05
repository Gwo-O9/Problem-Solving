/**
 * @param {number[]} nums
 * @return {number[]}
 */
var separateDigits = function(nums) {
    const ans = [];
    for(let i = 0; i<nums.length;i++){
        let temp = nums[i].toString();
        for(let j = 0; j<temp.length;j++){
            ans.push(temp.charAt(j));
        }
    }
    return ans;
};
