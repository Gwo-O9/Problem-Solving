#include <iostream>
#include <algorithm>
#include <string>
#include <set>
#include <vector>
using namespace std;

bool cmp(string a, string b) {
    if (a.length() != b.length()) {
        return a.length() < b.length();
    }
    return a < b;
}


int main(){
    set<string> ss;
    int n;
    string s;
    cin >> n;
    vector<string> arr(n);
    int index = 0;
    for(int i = 0; i<n;i++){
        string a;
        cin >> a;
        if(ss.find(a) != ss.end()) continue;
        arr[index] = a;
        ss.insert(a);
        index++;
    }
    int n2 = ss.size();
    vector<string> arr2(arr.begin(), arr.begin() + n2);
    sort(arr2.begin(), arr2.end(), cmp);
    for(int i = 0 ; i<n2;i++){
        cout << arr2[i] << "\n";
    }
    return 0;
}
