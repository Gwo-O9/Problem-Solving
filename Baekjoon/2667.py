from collections import deque

n = int(input())
graph = []
visited = [[False for _ in range(n)] for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
cnt_list = []
for _ in range(n):
    graph.append(list(map(int, input().strip())))

for i in range(n):
    for j in range(n):
        if visited[i][j] is False and graph[i][j] == 1:
            q = deque()
            q.append((i, j))
            visited[i][j]= True
            cnt = 1
            while q:
                x, y = q.popleft()
                for k in range(4):
                    nx, ny = x + dx[k], y + dy[k]
                    if nx < 0 or nx >= n or ny < 0 or ny >= n:
                        continue
                    if visited[nx][ny] is False and graph[nx][ny] == 1:
                        visited[nx][ny] = True
                        cnt += 1
                        q.append((nx, ny))
            cnt_list.append(cnt)

cnt_list.sort()
print(len(cnt_list))
for i in range(len(cnt_list)):
    print(cnt_list[i])
