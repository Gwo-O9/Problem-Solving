#include <iostream>
using namespace std;

long fact(long n);

int main(){
    long n,k;
    cin >> n >> k;
    long ans = fact(n)/(fact(n-k)*fact(k));
    cout << ans;
}

long fact(long n){
    if(n <= 1) return 1;
    return n*fact(n-1);
}
