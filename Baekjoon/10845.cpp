#include <iostream>
#include <string>
using namespace std;

int main(void){
    int n;
    cin >> n;
    int arr[n];
    int front = 0;
    int back = 0;
    for(int i = 0; i<n; i++){
        string cmd;
        cin >> cmd;
        if(cmd.compare("push") == 0){
            int temp;
            cin >> temp;
            arr[back] = temp;
            back++;
        }
        else if(cmd.compare("pop") == 0){
            if(front == back) cout << -1 << endl;
            else cout << arr[front++] << endl;
        }
        else if(cmd.compare("size") == 0){
            cout << (back - front) << endl;
        }
        else if(cmd.compare("empty") == 0){
            if(front == back) cout << 1 << endl;
            else cout << 0 << endl;
        }
        else if(cmd.compare("front") == 0){
            if(front == back) cout << -1 << endl;
            else cout << arr[front] << endl;
        }
        else if(cmd.compare("back") == 0){
            if(front == back) cout << -1 << endl;
            else cout << arr[back-1] << endl;
        }
    }
}
