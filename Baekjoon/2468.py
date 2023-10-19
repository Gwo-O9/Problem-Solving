from collections import deque

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
max_height = 0
directions = [[-1,0], [1,0], [0, -1], [0, 1]]
ans = 0
q = deque()
for i in range(n):
    for j in range(n):
        max_height = max(max_height, arr[i][j])

for h in range(max_height+1):
    visited = [[0] * n for _ in range(n)]
    cnt = 0
    q.clear()
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0 and arr[i][j] >= h:
                q = deque([(i, j)])
                cnt += 1
                while q:
                    x, y = q.popleft()
                    visited[x][y] = 1
                    for d in range(4):
                        nx, ny = x + directions[d][0], y + directions[d][1]
                        if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0 and arr[nx][ny] >= h:
                            visited[nx][ny] = 1
                            q.append((nx, ny))
    ans = max(cnt, ans)

print(ans)
