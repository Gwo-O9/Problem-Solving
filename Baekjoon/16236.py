from collections import deque

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
shark_size = 2
direction = [[0, -1], [0, 1], [-1, 0], [1, 0]]
shark = (0, 0)
for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            shark = (i, j)
            graph[i][j] = 0
time = 0
eaten_count = 0
while True:
    candidates = deque()
    q = deque([(shark[0], shark[1], 0)])  # x, y, time
    visited = [[False for _ in range(n)] for _ in range(n)]
    while q:
        x, y, t = q.popleft()
        visited[x][y] = True
        for i in range(4):
            nx, ny = x + direction[i][0], y + direction[i][1]
            if (0 <= nx < n) and (0 <= ny < n) and visited[nx][ny] is False and graph[nx][ny] <= shark_size:
                visited[nx][ny] = True
                q.append((nx, ny, t + 1))
                if graph[nx][ny] != 0 and graph[nx][ny] != shark_size:
                    candidates.append((nx, ny, t + 1))

    if len(candidates) == 0:
        break
    elif len(candidates) == 1:
        x, y, t = candidates.popleft()
        graph[x][y] = 0
        shark = (x, y)
        time += t
        eaten_count += 1
    else:
        c = sorted(candidates, key=lambda t: (t[2], t[0], t[1]))
        x, y, t = c[0]
        graph[x][y] = 0
        shark = (x, y)
        time += t
        eaten_count += 1

    if eaten_count == shark_size:
        shark_size += 1
        eaten_count = 0

print(time)
