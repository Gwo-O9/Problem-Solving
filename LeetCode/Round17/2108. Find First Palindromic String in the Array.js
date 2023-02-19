/**
 * @param {string[]} words
 * @return {string}
 */
var firstPalindrome = function(words) {
    for(let i = 0; i<words.length;i++){
        var left = 0;
        var right = words[i].length-1;
        while(left < right){
            if(words[i].charAt(left) !== words[i].charAt(right)) break;
            else{
                left++;
                right--;
            }
        }
        if(left >= right) return words[i];
    }
    return "";
};
