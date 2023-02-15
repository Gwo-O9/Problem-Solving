/**
 * @param {number} left
 * @param {number} right
 * @return {number[]}
 */
var selfDividingNumbers = function(left, right) {
    function isselfdiv(num){
        let numstr = num.toString();
        let n = numstr.length;
        for(let i = 0; i<n;i++){
            if(num % numstr.charAt(i) != 0) return false;
        }
        return true;
    }
    let ans = [];
    for(let i = left;i<=right;i++){
        if(isselfdiv(i) == true){
            ans.push(i);
        }
    }
    return ans;
};
