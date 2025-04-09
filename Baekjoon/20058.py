# 13:55
from copy import deepcopy
from collections import deque


N, Q = map(int, input().split())
n = 2**N
graph = [list(map(int, input().split())) for _ in range(n)]
magics = list(map(int, input().split()))
directions = [[0, -1], [0, 1], [1, 0], [-1, 0]]

def rotate_graph(graph, magic_number):
    new_graph = deepcopy(graph)
    size = 2**magic_number
    for i in range(0, n, size):
        for j in range(0, n, size):
            for x in range(size):
                for y in range(size):
                    new_graph[i + y][j + size - 1 - x] = graph[i + x][j + y]
    return new_graph

def melt(graph):
    new_graph = deepcopy(graph)
    for i in range(n):
        for j in range(n):
            if graph[i][j] <= 0:
                continue
            cnt = 0
            for d in range(4):
                nx, ny = i + directions[d][0], j + directions[d][1]
                if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] > 0:
                    cnt += 1
            if cnt < 3:
                new_graph[i][j] -= 1
    return new_graph

def get_remians(graph):
    global n
    remains = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] > 0:
                remains += graph[i][j]
    return remains

def get_max_remain_ice(graph):
    global n, directions
    max_size = 0
    visited = [[False for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j] or graph[i][j] <= 0:
                continue
            q = deque([(i, j)])
            cnt = 1
            while q:
                x, y = q.popleft()
                visited[x][y] = True
                for d in range(4):
                    nx, ny = x + directions[d][0], y + directions[d][1]
                    if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and graph[nx][ny] > 0:
                        q.append((nx, ny))
                        visited[nx][ny] = True
                        cnt = cnt + 1
            max_size = max(max_size, cnt)
    return max_size


for magic in magics:
    graph = rotate_graph(graph, magic)
    graph = melt(graph)

print(get_remians(graph))
print(get_max_remain_ice(graph))

