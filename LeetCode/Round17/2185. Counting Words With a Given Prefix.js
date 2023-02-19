/**
 * @param {string[]} words
 * @param {string} pref
 * @return {number}
 */
var prefixCount = function(words, pref) {
    var cnt = 0;
    for(let i = 0; i<words.length;i++){
        if(words[i].slice(0,pref.length) === pref) cnt++;
    }
    return cnt;
};
