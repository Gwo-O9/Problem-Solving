/**
 * @param {string} word
 * @return {boolean}
 */
var detectCapitalUse = function(word) {
    if(word.toUpperCase() === word) return true;
    else if(word.toLowerCase() === word) return true;
    else if(word.charCodeAt(0) >= 65 && word.charCodeAt(0) <= 90 && word.slice(1,word.length).toLowerCase() === word.slice(1,word.length)) return true
    else return false;
};
