from collections import deque

m, n, h = map(int, input().split())
tomatoes = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]

directions = [[-1, 0, 0], [1, 0, 0], [0, 1, 0], [0, -1, 0], [0, 0, -1], [0, 0, 1]]
cnt = 0
expected_cnt = m*n*h
ans = 0
q = deque()
for i in range(n):
    for j in range(m):
        for k in range(h):
            if tomatoes[k][i][j] == 1:
                q.append([i, j, k, 0])
            if tomatoes[k][i][j] == -1:
                expected_cnt -= 1

cnt = len(q)

while q:
    x, y, z, time = q.popleft()
    for i in range(6):
        nx, ny, nz = x + directions[i][0], y + directions[i][1], z + directions[i][2]
        if 0 <= nx < n and 0 <= ny < m and 0 <= nz < h and tomatoes[nz][nx][ny] == 0:
            tomatoes[nz][nx][ny] = 1
            cnt += 1
            q.append((nx, ny, nz, time+1))
    ans = time

if cnt == expected_cnt:
    print(ans)
else:
    print(-1)
