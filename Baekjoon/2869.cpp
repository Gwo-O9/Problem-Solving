#include <iostream>
using namespace std;

int main(){
    int day, night, V;
    cin >> day >> night >> V;
    int one = day - night;
    if((V-night)% one == 0) cout << (V-night)/one;
    else cout << (V-night)/one+1;
}
