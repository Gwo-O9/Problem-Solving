from collections import deque

n = int(input())

graph = [list(map(int, input().split())) for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
ans = 0
for i in range(0, 100):
    visited = [[False for _ in range(n)] for _ in range(n)]
    cnt = 0
    for j in range(n):
        for k in range(n):
            if visited[j][k] is False and graph[j][k] > i:
                q = deque([(j, k)])
                while q:
                    x, y = q.popleft()
                    for t in range(4):
                        nx, ny = x + dx[t], y + dy[t]
                        if nx < 0 or nx >= n or ny < 0 or ny >= n:
                            continue
                        if graph[nx][ny] > i and visited[nx][ny] is False:
                            visited[nx][ny] = True
                            q.append((nx,ny))
                cnt+=1
    ans = max(cnt,ans)

print(ans)