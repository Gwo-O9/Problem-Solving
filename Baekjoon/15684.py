# 세로선의 개수 N, 가로선의 개수 M, 세로선마다 가로선을 놓을 수 있는 위치의 개수 H
n, m, h = map(int, input().split())
ladder = [[0 for _ in range(n)] for _ in range(h)]
for _ in range(m):
    a, b = map(int, input().split())
    # b번 세로선과 b+1번 세로선을 a번 점선 위치에서 연결했다는 의미
    ladder[a - 1][b - 1] = 1
ans = 4

if m == 0:
    print(0)
    exit()


def is_straight():
    global n, h, ladder
    for start in range(n):  # 모든 세로 선 시작 점에 대해서
        now = start
        for j in range(h):  # 내려가며 가로선을 체크
            if ladder[j][now] == 1:  # 우측 이동
                now += 1
            elif now > 0 and ladder[j][now - 1] == 1:  # 좌측 이동
                now -= 1
        if now != start:
            return False
    return True


# x는 지금 탐색중인 행
def dfs(cnt, x):
    global ans
    if ans <= cnt:
        return
    if is_straight():
        ans = min(ans, cnt)
        return
    if cnt == 3:
        return
    
    for i in range(x, h):
        for j in range(0, n - 1):
            if ladder[i][j] == 0:
                ladder[i][j] = 1
                dfs(cnt + 1, i)
                ladder[i][j] = 0


dfs(0, 0)
print(ans) if ans < 4 else print(-1)
