#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int x,y,r,l;
    cin >> x >> y >> r >> l;
    int ans = 10000;
    ans = min(r-x,ans);
    ans = min(l-y,ans);
    ans = min(x,ans);
    ans = min(y,ans);
    cout << ans;
}
