/**
 * @param {number[]} gain
 * @return {number}
 */
var largestAltitude = function(gain) {
    var max = 0;
    var now = 0;
    for(let i = 0; i<gain.length;i++){
        now += gain[i];
        max = Math.max(now,max);
    }
    return max;
};
