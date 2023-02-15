/**
 * @param {string} coordinates
 * @return {boolean}
 */
var squareIsWhite = function(coordinates) {
    let a = coordinates.charCodeAt(0)
    let b = coordinates.charAt(1)
    if(a % 2 == 1 && b % 2 == 1) return false;
    else if(a % 2 == 1 && b % 2 == 0) return true;
    else if(a % 2 == 0 && b % 2 == 1) return true;
    else return false;
};
