/**
 * @param {number[]} startTime
 * @param {number[]} endTime
 * @param {number} queryTime
 * @return {number}
 */
var busyStudent = function(startTime, endTime, queryTime) {
    var cnt = 0;
    let n = startTime.length;
    for(let i = 0; i<n;i++){
        if(startTime[i] <= queryTime && endTime[i] >= queryTime){
            cnt++;
        }
    }
    return cnt;
};
