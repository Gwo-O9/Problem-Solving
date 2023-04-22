#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    int ans = 100000;
    for(int i = 0; i<=n/5;i++){
        for(int j = 0; j<=n/3;j++){
            if((i*5) + (j*3) == n) ans = min(ans, i+j);
        }
    }
    if(ans == 100000) cout << -1 << endl;
    else cout << ans << endl;
}
