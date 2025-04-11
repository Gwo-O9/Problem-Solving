from collections import deque
from itertools import combinations
import math

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
hospitals = []
directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
ans = math.inf
virus_cnt = 0
for i in range(n):
    for j in range(n):
        if graph[i][j] == 2:
            hospitals.append((i, j))
            graph[i][j] = 3
        if graph[i][j] == 0:
            virus_cnt += 1

candidates = list(combinations(hospitals, m))

for candidate in candidates:
    q = deque()
    visited = [[False for _ in range(n)] for _ in range(n)]
    for x, y in candidate:
        visited[x][y] = True
        q.append((x, y, 0))
    cnt = math.inf
    caught_viruses = 0
    should_break = False
    while q:
        x, y, time = q.popleft()
        if caught_viruses == virus_cnt:
            cnt = min(time, cnt)
            break
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and graph[nx][ny] != 1:
                q.append((nx, ny, time + 1))
                visited[nx][ny] = True
                if graph[nx][ny] == 0:
                    caught_viruses += 1
                    if caught_viruses == virus_cnt:
                        cnt = min(time + 1, cnt)
                        should_break = True
                        break
        if should_break:
            break

    if caught_viruses == virus_cnt:
        ans = min(ans, cnt)

print(ans) if ans != math.inf else print(-1)