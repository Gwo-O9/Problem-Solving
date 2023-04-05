#include <iostream>
using namespace std;

int main(){
    int n;
    cin >> n;
    int f = 1;
    int g = 1;
    int i = 3;
    if(n == 1 || n == 2){
        cout << 1;
        return 0;
    }
    while(i <=n){
        if(i%2 == 1) f += g;
        else g += f;
        i++;
    }
    if(n%2 == 1) cout << f << " " << n-2;
    else cout << g << " " << n-2;
    return 0;
}
