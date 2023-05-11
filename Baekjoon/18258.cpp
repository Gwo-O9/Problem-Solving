#include <stdio.h>
#include <string>
using namespace std;

int main(void){
    int n;
    scanf("%d", &n);
    int arr[n];
    int front = 0;
    int back = 0;
    for(int i = 0; i<n; i++){
        char tcmd[6];
        string cmd;
        scanf("%s", tcmd);
        cmd = tcmd;
        if(cmd.compare("push") == 0){
            int temp;
            scanf("%d", &temp);
            arr[back] = temp;
            back++;
        }
        else if(cmd.compare("pop") == 0){
            if(front == back) printf("-1\n");
            else printf("%d\n", arr[front++]);
        }
        else if(cmd.compare("size") == 0){
            printf("%d\n", back-front);
        }
        else if(cmd.compare("empty") == 0){
            if(front == back) printf("1\n");
            else printf("0\n");
        }
        else if(cmd.compare("front") == 0){
            if(front == back) printf("-1\n");
            else printf("%d\n", arr[front]);
        }
        else if(cmd.compare("back") == 0){
            if(front == back) printf("-1\n");
            else printf("%d\n", arr[back-1]);
        }
    }
}
