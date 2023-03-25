#include <iostream>
using namespace std;

int main(){
    int n;
    cin >> n;
    int i = 0;
    int num = 666;
    while(true){
        bool t = false;
        int temp = num;
        int c = 0;
        while(temp > 0){
            if(temp%10 == 6) {
                c++;
            }
            else{
                c = 0;
            }
            temp /= 10;
            if(c >= 3){
                i++;
                break;
            }
        }
        if(i == n) break;
        else num++;
    }
    cout << num;
    return 0;
}
