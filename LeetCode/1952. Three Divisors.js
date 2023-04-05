/**
 * @param {number} n
 * @return {boolean}
 */
var isThree = function(n) {
    cnt = 0;
    for(let i = 1; i<=n;i++){
        if(n%i===0) cnt++;
        if(cnt > 3) return false;
    }
    return cnt === 3 ? true : false;
};
