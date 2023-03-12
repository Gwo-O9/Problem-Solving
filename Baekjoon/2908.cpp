#include <iostream>
#include <cstring>
using namespace std;

int main(){
    string str1;
    string str2;
    cin >> str1 >> str2;
    string st1 = "";
    string st2 = "";
    int i;
    for(i = 0; i<str1.length();i++){
        st1 = st1 + str1[str1.length()-1-i];
        st2 = st2 + str2[str2.length()-1-i];
    }
    int ans = max(stoi(st1), stoi(st2));
    cout << ans << endl;
}
