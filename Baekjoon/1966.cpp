#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int T,n,k;
    scanf("%d", &T);
    for(int i = 0; i<T;i++){
        scanf("%d %d", &n, &k);
        vector<pair<int,bool>> v;
        v.clear();
        int arr[n];
        for(int j = 0; j<n;j++){
            int score;
            scanf("%d", &score);
            if(j == k) {
                pair<int,bool> p = make_pair(score,true);
                v.push_back(p);
                arr[j] = score;
            }
            else{
                pair<int,bool> p3 = make_pair(score,false);
                v.push_back(p3);
                arr[j] = score;
            }
        }
        int index = 0;
        sort(arr, arr+n,greater<int>());
        while(true){
            if(arr[index] != v[0].first){
                pair<int,bool> p2 = make_pair(v[0].first, v[0].second);
                v.erase(v.begin());
                v.push_back(p2);
            }
            else{
                if(v[0].second) {
                    printf("%d\n", index+1);
                    break;
                }
                else{
                    v.erase(v.begin());
                    index++;
                }
            }
        }
    }
    return 0;
}
