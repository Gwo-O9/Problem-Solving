#include <iostream>
using namespace std;

int main(){
    int n,m;
    cin >> n >> m;
    int arr[n];
    int i = 0;
    for(i = 0; i<n;i++){
        arr[i] = i+1;
    }
    int q,w;
    for(int i = 0; i<m;i++){
        cin >> q >> w;
        int temp = arr[q-1];
        arr[q-1] = arr[w-1];
        arr[w-1] = temp;
    }
    for(int i = 0; i<n;i++){
        cout << arr[i] << " ";
    }
}
