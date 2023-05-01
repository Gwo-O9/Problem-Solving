#include <iostream>
using namespace std;

int main(){
    int n;
    cin >> n;
    int cnt = 4;
    for(int i = 0; i*i<50001;i++){
        for(int j = 0; j*j <50001;j++){
            for(int k = 0; k*k < 50001;k++){
                for(int w = 0; w*w < 50001; w++){
                    if(i*i + j*j + k*k + w*w == n) {
                        if(i == 0) cnt--;
                        if(j == 0) cnt--;
                        if(k == 0) cnt--;
                        if(w == 0) cnt--;
                        cout << cnt << endl;
                        return 0;
                    }
                }
            }
        }
    }
}
