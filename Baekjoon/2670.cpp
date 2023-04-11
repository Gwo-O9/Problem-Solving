#include <iostream>
#include <algorithm>
#include <stdio.h>
using namespace std;

int main(){
    int n;
    cin >> n;
    double arr[n];
    for(int i = 0; i<n;i++){
        scanf("%lf", &arr[i]);
    }
    double maxvalue = -1.0;
    for(int i = 0; i<n;i++){
        double temp = 1.0;
        for(int j = i; j < n; j++){
            temp *= arr[j];
            maxvalue = max(temp, maxvalue);
        }
    }
    printf("%.3lf\n", maxvalue);
}
