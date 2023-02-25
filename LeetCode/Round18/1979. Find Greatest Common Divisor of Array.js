/**
 * @param {number[]} nums
 * @return {number}
 */
var findGCD = function(nums) {
    let min = Infinity;
    let max = -Infinity;
    let ans = 1;
    for(let x of nums){
        min = Math.min(min,x);
        max = Math.max(max,x);
    }
    for(let i = 2; i<=min;i++){
        if(min%i === 0 && max%i === 0) ans = i;
    }
    return ans;
};
