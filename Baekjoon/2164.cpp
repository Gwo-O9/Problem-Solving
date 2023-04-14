#include <iostream>
#include <deque>
using namespace std;

int main() {
    int n;
    cin >> n;
    deque<int> dq;
    for (int i = 0; i < n; i++) {
        dq.push_back(i + 1);
    }
    while (dq.size() > 1) {
        dq.pop_front();       // 첫 번째 원소 삭제
        int next = dq.front(); // 두 번째 원소 확인
        dq.pop_front();       // 두 번째 원소 삭제
        dq.push_back(next);   // 삭제한 두 번째 원소를 뒤로 옮김
    }
    cout << dq.front() << endl; // 마지막 남은 원소 출력
}
