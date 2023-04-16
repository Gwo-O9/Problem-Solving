#include <stdio.h>
#include <iostream>
using namespace std;

int main(){
    int n;
    scanf("%d", &n);
    int arr[n][2];
    int rank[n];
    for(int i = 0 ;i< n; i++){
        scanf("%d %d", &arr[i][0], &arr[i][1]);
    }
    for(int i = 0;i<n;i++){
        int temp = 1;
        for(int j = 0; j<n;j++){
            if(i == j) continue;
            if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) temp++;
        }
        rank[i] = temp;
    }
    printf("%d", rank[0]);
    for(int i = 1; i<n;i++){
        printf(" %d", rank[i]);
    }
}
