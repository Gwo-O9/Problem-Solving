#include <iostream>
using namespace std;

int main(){
    int n;
    cin >> n;
    long arr[15][15];
    for(int i = 0; i<15;i++){
        arr[0][i] = i+1;
    }
    
    for(int i = 1; i<15;i++){
        for(int j = 0; j<15;j++){
            if(j == 0) arr[i][j] = arr[i-1][j];
            else arr[i][j] = (arr[i][j-1] + arr[i-1][j]);  
        }
    }

    for(int i = 0; i<n;i++){
        int h = 0;
        int k = 0;
        cin >> h >> k;
        cout << arr[h][k-1] << endl;
    }
}
