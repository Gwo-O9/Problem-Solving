from itertools import combinations
from copy import deepcopy
from collections import deque

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
fire = []
empty = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            empty.append((i, j))
        elif graph[i][j] == 2:
            fire.append((i, j))

def get_empty_candidates():
    return list(combinations(empty, 3))

def make_wall(walls):
    tmp_graph = deepcopy(graph)
    for wall in walls:
        x, y = wall
        tmp_graph[x][y] = 1
    return tmp_graph

def go_fire(t_graph):
    q = deque(fire)
    visited = [[False for _ in range(m)] for _ in range(n)]
    while q:
        x, y = q.popleft()
        visited[x][y] = True
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if 0 <= nx < n and 0 <= ny < m and t_graph[nx][ny] == 0 and not visited[nx][ny]:
                visited[nx][ny] = True
                t_graph[nx][ny] = 2
                q.append((nx, ny))

def get_empty_cnt(t_graph):
    cnt = 0
    for i in range(n):
        for j in range(m):
            if t_graph[i][j] == 0:
                cnt +=1
    return cnt

max_val = 0
candidates = get_empty_candidates()
for candidate in candidates:
    t_graph = make_wall(candidate)
    go_fire(t_graph)
    cnt = get_empty_cnt(t_graph)
    max_val = max(max_val, cnt)

print(max_val)