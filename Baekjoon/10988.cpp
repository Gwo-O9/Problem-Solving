#include <iostream>
#include <cstring>
using namespace std;

int main(){
    string str;
    cin >> str;
    int n = str.length();
    for(int i = 0; i<n/2+1;i++){
        if(str[i] != str[n-1-i]) {
            cout << 0;
            return 0;
        }
    }
    cout << 1;
    return 0;
}
