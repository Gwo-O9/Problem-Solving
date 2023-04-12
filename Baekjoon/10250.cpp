#include <iostream>
using namespace std;

int main(){
    int T,h,w,n;
    cin >> T;
    for(int i = 0; i<T;i++){
        cin >> h >> w >> n;
        int y = 0;
        int x = 1;
        int j = 0;
        while(j < n){
            y++;
            if(y==h+1){
                y = 1;
                x++;
            }
            j++;
        }
        cout << (y*100 + x) << endl;
    }
}
