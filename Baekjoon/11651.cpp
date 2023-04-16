#include <stdio.h>
#include <algorithm>
#include <vector>
using namespace std;

bool cmp(const std::pair<int, int>& a, const std::pair<int, int>& b) {
    if(a.second != b.second) return a.second < b.second;
    else return a.first < b.first;

}

int main(){
    int n;
    scanf("%d", &n);
    vector<pair<int,int> > v(n);
    for(int i = 0; i< n; i++){
        scanf("%d %d", &v[i].first, &v[i].second);
    }
    sort(v.begin(), v.end(),cmp);
    for(int i = 0; i< n;i++){
        printf("%d %d\n", v[i].first, v[i].second);
    }
}
