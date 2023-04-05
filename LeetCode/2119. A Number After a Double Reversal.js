/**
 * @param {number} num
 * @return {boolean}
 */
var isSameAfterReversals = function(num) {
    if(num === 0) return true;
    let temp = num.toString();
    let i = 0;
    while(true){
        if(temp.charAt(temp.length-1-i) === '0') return false;
        else{
            return true;
        }
    }
};
