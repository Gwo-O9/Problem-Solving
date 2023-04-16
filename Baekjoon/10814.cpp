#include <cstdio>
#include <algorithm>
#include <utility>
#include <string>
#include <vector>
using namespace std;

bool cmp(const std::pair<int, string>& a, const std::pair<int, string>& b) {
    return a.first < b.first;
}

int main(){
    int n;
    scanf("%d", &n);
    vector<pair<int, string> > arr(n);
    for(int i = 0; i<n;i++){
        char name[101];
        scanf("%d %100s", &arr[i].first, name);
        arr[i].second = name;
    }
    stable_sort(arr.begin(), arr.end(), cmp);
    for(int i = 0; i<n;i++){
        printf("%d %s\n", arr[i].first, arr[i].second.c_str());
    }
    return 0;
}
