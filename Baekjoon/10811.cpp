#include <iostream>
#include <algorithm>
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
        reverse(arr+q-1,arr+w);
    }
    for(int i = 0; i<n;i++){
        cout << arr[i] << " ";
    }
}
