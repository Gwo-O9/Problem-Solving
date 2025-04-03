import copy
from itertools import combinations
from collections import deque


def pick_virus_xy(candidates, M):
    return list(combinations(candidates, M))


N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
direction = [[0, -1], [0, 1], [1, 0], [-1, 0]]
ans = 10000000
candidates = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == 2:
            graph[i][j] = '*'
            candidates.append((i, j))
        elif graph[i][j] == 1:
            graph[i][j] = '-'
        else:
            graph[i][j] = -1

active_candidates = pick_virus_xy(candidates, M)
for candidates in active_candidates:
    time = 0
    q = deque()
    visited = [[False for _ in range(N)] for _ in range(N)]
    tmp_graph = copy.deepcopy(graph)
    for x, y in candidates:
        tmp_graph[x][y] = 0
        q.append((x, y))
        visited[x][y] = True
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + direction[i][0], y + direction[i][1]
            if (0 <= nx < N) and (0 <= ny < N) and visited[nx][ny] is False and tmp_graph[x][y] != '-':
                if tmp_graph[nx][ny] == -1:
                    tmp_graph[nx][ny] = tmp_graph[x][y] + 1
                    time = max(time, tmp_graph[nx][ny])
                elif tmp_graph[nx][ny] == '*':
                    tmp_graph[nx][ny] = tmp_graph[x][y] + 1
                q.append((nx, ny))
                visited[nx][ny] = True


    for i in range(N):
        for j in range(N):
            if tmp_graph[i][j] == -1:
                time = -1

    if time != -1:
        ans = min(time, ans)

print(ans) if ans != 10000000 else print(-1)
