#include <iostream>
using namespace std;

int main(){
    int n;
    cin >> n;
    int i = 1;
    int index = 6;
    int room = 1;
    while(i<n){
        i += index;
        room++;
        index += 6;
    }
    cout << room;
    return 0;
}
