/**
 * @param {string} word
 * @param {character} ch
 * @return {string}
 */
var reversePrefix = function(word, ch) {
    var index = 0;
    for(let i = 0; i<word.length;i++){
        if(word.charAt(i) === ch) break;
        else index++;
    }
    if(index == word.length) return word;
    var left = word.slice(0, index+1);
    var leftreverse = left.split('').reverse().toString().replaceAll(',',"");
    var right = word.slice(index+1, word.length);
    return leftreverse + right;
};
