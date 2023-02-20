/**
 * @param {string[]} names
 * @param {number[]} heights
 * @return {string[]}
 */
var sortPeople = function(names, heights) {
    var n = names.length;
    for(let i = 0; i<n-1;i++){
        for(let j = i+1; j<n;j++){
            if(heights[i] < heights[j]){
                [names[i], names[j]] = [names[j], names[i]];
                [heights[i], heights[j]] = [heights[j], heights[i]];
            }
        }
    }
    return names;
};
