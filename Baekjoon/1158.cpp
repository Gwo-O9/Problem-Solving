#include <iostream>
#include <list>

using namespace std;

int main(){
    int N, K;
    cin >> N >> K;
    list<int> mylist;

    for(int i = 1; i <= N; i++){
        mylist.push_back(i);
    }
    list<int>::iterator itr = mylist.begin();

    cout << "<";
    while(!mylist.empty()){
        for(int i = 0; i<K-1;i++){
            itr++;
            if(itr == mylist.end()) itr = mylist.begin();
        }
        if(mylist.size() == 1) cout << *itr;
        else cout << *itr << ", ";
        mylist.erase(itr++);
        if(itr == mylist.end()) itr = mylist.begin();
    }
    cout << ">";
    return 0;
}
