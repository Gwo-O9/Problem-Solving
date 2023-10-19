from collections import deque

m, n = map(int, input().split())
tomatoes = [list(map(int, input().split())) for _ in range(n)]
directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
cnt = 0
expected_cnt = m*n
ans = 0
q = deque()
for i in range(n):
    for j in range(m):
        if tomatoes[i][j] == 1:
            q.append([i, j, 0])
        if tomatoes[i][j] == -1:
            expected_cnt -= 1

cnt = len(q)

while q:
    x, y, time = q.popleft()
    for i in range(4):
        nx, ny = x + directions[i][0], y + directions[i][1]
        if 0 <= nx < n and 0 <= ny < m and tomatoes[nx][ny] == 0:
            tomatoes[nx][ny] = 1
            cnt += 1
            q.append((nx, ny, time+1))
    ans = time+1

if cnt == expected_cnt:
    print(ans-1)
else:
    print(-1)

