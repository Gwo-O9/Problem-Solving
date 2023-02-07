/**
 * @param {number} a
 * @param {number} b
 * @return {number}
 */
var commonFactors = function(a, b) {
    const max = Math.max(a,b);
    var ans = 0;
    for(var i = 1; i<=max;i++){
        if(a%i == 0 && b%i == 0) ans++;
    }
    return ans;
};
