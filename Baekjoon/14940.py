from collections import deque

directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]


found = False
for i in range(n):
    for j in range(m):
        if arr[i][j] == 2:
            x, y = i, j
            found = True
            break
    if found:
        break

ans = [[0]*m for _ in range(n)]

que = deque([(x,y,0)])
ans[x][y] = 0

while que:
    dx, dy, t = que.popleft()
    for i in range(4):
        nx, ny = dx + directions[i][0], dy + directions[i][1]
        if 0 <= nx < n and 0 <= ny < m and ans[nx][ny] == 0 and arr[nx][ny] == 1:
            ans[nx][ny] = t+1
            que.append((nx, ny, t+1))

for i in range(n):
    for j in range(m):
        if arr[i][j] == 1 and ans[i][j] == 0:
            print(-1, end=" ")
        else:
            print(ans[i][j], end=" ")
    print()
