/**
 * @param {number} n
 * @return {number[]}
 */
var sumZero = function(n) {
    const ans = [];
    if(n%2==0){
        for(let i = 1; i<=n/2;i++){
            ans.push(i);
            ans.push(-i);
        }
    }
    else{
        ans.push(0);
        for(let i = 1;i<n/2;i++){
            ans.push(i);
            ans.push(-i);
        }
    }
    return ans;
};
