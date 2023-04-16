#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void){
    int n;
    cin >> n;
    vector<int> v;

    for(int i = 0; i<n;i++){
        string cmd;
        cin >> cmd;
        int temp;
        if(cmd.compare("push_back") == 0){
            cin >> temp;
            v.push_back(temp);
        }
        else if(cmd.compare("push_front") == 0){
            cin >> temp;
            v.insert(v.begin(),temp);
        }
        else if(cmd.compare("pop_front") == 0){
            if(v.size() == 0) cout << -1 << endl;
            else {
                cout << v[0] << endl;
                v.erase(v.begin());
            }
        }
        else if(cmd.compare("pop_back") == 0){
            if(v.size() == 0) cout << -1 << endl;
            else {
                cout << v[v.size()-1] << endl;
                v.pop_back();
            }
        }
        else if(cmd.compare("size") == 0){
            cout << v.size() << endl;
        }
        else if(cmd.compare("empty") == 0){
            if(v.size() == 0) cout << 1 << endl;
            else cout << 0 << endl;
        }
        else if(cmd.compare("front") == 0){
            if(v.size() == 0) cout << -1 << endl;
            else cout << v[0] << endl;
        }
        else if(cmd.compare("back") == 0){
            if(v.size() == 0) cout << -1 << endl;
            else cout << v[v.size()-1] << endl;
        }
    }
}
