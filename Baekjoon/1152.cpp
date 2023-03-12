#include <iostream>
#include <cstring>
using namespace std;

int main(){
    string str;
    getline(cin, str);
    int cnt = 0;
    bool is_word = false; 
    for(int i = 0; i < str.length(); i++){
        if(str[i] == ' '){ 
            if(is_word){ 
                cnt++; 
                is_word = false;
            }
        }
        else{
            is_word = true; 
        }
    }
    if(is_word) cnt++; 
    cout << cnt << endl;
    return 0;
}
