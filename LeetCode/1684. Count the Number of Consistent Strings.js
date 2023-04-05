/**
 * @param {string} allowed
 * @param {string[]} words
 * @return {number}
 */
var countConsistentStrings = function(allowed, words) {
    let cnt = 0;
    for(let i = 0; i<words.length;i++){
        for(let j = 0; j<words[i].length;j++){
            if(allowed.indexOf(words[i].charAt(j)) === -1){
                cnt++;
                break;
            }     
        }
    }
    return (words.length - cnt);
};
