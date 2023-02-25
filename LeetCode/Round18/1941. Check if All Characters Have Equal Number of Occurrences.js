/**
 * @param {string} s
 * @return {boolean}
 */
var areOccurrencesEqual = function(s) {
    const checker = new Array(26).fill(0);
    for(let i = 0; i<s.length;i++){
        checker[s.charCodeAt(i) - 97]++;
    }
    const occ = checker[s.charCodeAt(0) - 97];
    for(let j = 0; j<26;j++){
        if(checker[j] === 0) continue;
        else if(checker[j] !== occ) return false;
    }
    return true;
};
