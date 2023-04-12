#include <stdio.h>
#include <algorithm>
#include <utility>
using namespace std;

int main(){
    int n;
    scanf("%d", &n);
    pair<int,int> arr[n];
    for(int i = 0; i<n;i++){
        scanf("%d %d", &arr[i].first, &arr[i].second);
    }
    sort(arr,arr+n);
    for(int i = 0; i<n;i++){
        printf("%d %d\n", arr[i].first, arr[i].second);
    }
}
