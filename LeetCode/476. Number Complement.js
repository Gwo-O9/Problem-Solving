/**
 * @param {number} num
 * @return {number}
 */
var findComplement = function(num) {
    var a = 0; var t = num;
    while(t > 0){
        t >>= 1;
        a++;
    }
    var mask = (1<<(a))-1;
    return num^mask;
};
