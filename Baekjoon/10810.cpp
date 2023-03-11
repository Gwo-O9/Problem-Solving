#include <iostream>
using namespace std;

int main(){
    int n,m;
    cin >> n >> m;
    int arr[n] = { 0 };
    int q,w,e;
    for(int i = 0; i<m;i++){
        cin >> q >> w >> e;
        for(int j = q-1; j<w;j++){
            arr[j] = e;
        }
    }
    for(int i = 0; i<n;i++){
        cout << arr[i] << " ";
    }
}
