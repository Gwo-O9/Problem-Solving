#include <iostream>
using namespace std;

int main(){
    int a,b,l,g;
    cin >> a >> b;
    int gcd = 1;
    for(int i = min(a, b); i > 1; i--){
        if(a % i == 0 && b % i == 0) {
            gcd = i;
            break;
        }
    }
    cout << gcd << "\n" << (a*b)/gcd <<endl;
    return 0;
}
