#include <iostream>
#include <cstring>
using namespace std;

int main(){
    int n, i, m, j, k;
    cin >> n;
    string str;
    for(i = 0;i<n;i++){
        cin >> m >> str;
        for(j = 0;j<str.length();j++){
            for(k = 0;k<m;k++){
                cout << str[j];
            }
        }
        cout << "\n";
    }
    return 0;
}
