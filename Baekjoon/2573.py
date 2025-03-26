from collections import deque

N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
cnt = 0
time = 0
while True:
    visited = [[False for _ in range(M)] for _ in range(N)]
    should_minus = [[0 for _ in range(M)] for _ in range(N)]

    cnt = 0

    for i in range(N):
        for j in range(M):
            if graph[i][j] > 0 and visited[i][j] is False:
                cnt += 1
                q = deque([(i, j)])
                visited[i][j] = True
                while q:
                    x, y = q.popleft()
                    for k in range(4):
                        nx, ny = x + dx[k], y + dy[k]
                        if nx < 0 or nx >= N or ny < 0 or ny >= M or graph[nx][ny] <= 0:
                            continue
                        if visited[nx][ny] is False:
                            q.append((nx, ny))
                            visited[nx][ny] = True

    if cnt > 1:
        print(time)
        break

    # check should minus
    for i in range(N):
        for j in range(M):
            if graph[i][j] > 0:
                for k in range(4):
                    nx, ny = i + dx[k], j + dy[k]
                    if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] <= 0:
                        should_minus[i][j] += 1
    if max(map(max, should_minus)) == 0 or cnt == 0:
        print(0)
        break
    # minus simultaneously
    for i in range(N):
        for j in range(M):
            graph[i][j] -= should_minus[i][j]

    time += 1