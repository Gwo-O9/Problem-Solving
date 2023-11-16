import sys

input = sys.stdin.readline

N, M = map(int, input().split())
cmds = []
arr = []
dp = [[0] * (N + 1) for _ in range(N + 1)]
for i in range(N):
    arr.append(list(map(int, input().split())))
for i in range(M):
    cmds.append(list(map(int, input().split())))

for i in range(1, N + 1):
    for j in range(1, N + 1):
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i - 1][j - 1]

for i in range(M):
    x1, x2, y1, y2 = cmds[i]
    ans = dp[y1][y2] - dp[x1 - 1][y2] - dp[y1][x2 - 1] + dp[x1 - 1][x2 - 1]
    print(ans)
