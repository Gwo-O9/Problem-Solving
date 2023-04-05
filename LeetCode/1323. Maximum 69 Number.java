/**
 * @param {number} num
 * @return {number}
 */
var maximum69Number = function(num) {
    let numStr = num.toString();
    let n = numStr.length;
    let max = num;
    for (let i = 0; i < n; i++) {
        if (numStr.charAt(i) === '6') {
            max = num + 3 * Math.pow(10, n - i - 1);
            break;
        }
    }
    return max;
};
