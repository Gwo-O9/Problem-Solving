from collections import deque

# D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
# S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
# L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
# R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.

T = int(input())

for _ in range(1, T+1):
    num, target = map(int, input().split())
    q = deque([(num, "")])
    visited =[0]*10001
    visited[num] = 1
    cmd_list = []
    ans = "Y"*1000000
    while q:
        x, cmd = q.popleft()
        if len(cmd) >= len(ans):
            break
        D = x*2 if x*2 < 10000 else x*2%10000
        S = x-1 if x != 0 else 9999
        num_1 = x//1000
        num_2 = x//100 - num_1*10
        num_3 = x//10 - num_1*100 - num_2*10
        num_4 = x - num_1*1000 - num_2*100 - num_3*10
        L = num_2*1000 + num_3*100 + num_4*10 + num_1
        R = num_4*1000 + num_1*100 + num_2*10 + num_3
        for nxt, c in [(D, "D"), (S, "S"), (L, "L"), (R, "R")]:
            if visited[nxt] == 0:
                visited[nxt] = 1
                q.append((nxt, cmd + c))

                if nxt == target and len(ans) >= len(cmd) + 1:
                    ans = cmd + c
    print(ans)
