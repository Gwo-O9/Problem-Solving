from copy import deepcopy
from collections import deque

N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]
visited = [[False for _ in range(M)] for _ in range(N)]
directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
ans = 0


def make_wall(cnt):
    global graph
    if cnt == 3:
        virus_simulation()
        return
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                graph[i][j] = 1
                make_wall(cnt + 1)
                graph[i][j] = 0


def virus_simulation():
    global graph, ans, N
    q = deque()
    cnt = 0
    new_graph = deepcopy(graph)
    virus_visited = [[False for _ in range(M)] for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if new_graph[i][j] == 2:
                q.append((i, j))
                virus_visited[i][j] = True

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + directions[i][0], y + directions[i][1]
            if not (0 <= nx < N) or not (0 <= ny < M) or virus_visited[nx][ny] is True:
                continue
            if new_graph[nx][ny] == 0:
                new_graph[nx][ny] = 2
                q.append((nx, ny))
                virus_visited[nx][ny] = True

    for i in range(N):
        cnt += new_graph[i].count(0)

    ans = max(ans, cnt)


make_wall(0)
print(ans)
