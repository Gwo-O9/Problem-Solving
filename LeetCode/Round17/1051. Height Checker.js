/**
 * @param {number[]} heights
 * @return {number}
 */
var heightChecker = function(heights) {
    const temp = heights.slice().sort((a, b) => a - b);
    let n = heights.length
    let cnt = 0;
    for(let i = 0; i<n;i++){
        if(temp[i] !== heights[i]) cnt++;
    }
    return cnt;
};
