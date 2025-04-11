from copy import deepcopy
from collections import deque

n, q = map(int, input().split())
N = 2 ** n
graph = [list(map(int, input().split())) for _ in range(N)]
levels = list(map(int, input().split()))
directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]


def rotate(graph, level):
    subgrid_size = 2 ** level
    new_graph = [row[:] for row in graph]

    for i in range(0, N, subgrid_size):
        for j in range(0, N, subgrid_size):
            half = subgrid_size // 2

            for r in range(half):
                for c in range(half):
                    new_graph[i + r][j + c] = graph[i + r + half][j + c]
            for r in range(half):
                for c in range(half):
                    new_graph[i + r][j + c + half] = graph[i + r][j + c]
            for r in range(half):
                for c in range(half):
                    new_graph[i + r + half][j + c + half] = graph[i + r][j + c + half]
            for r in range(half):
                for c in range(half):
                    new_graph[i + r + half][j + c] = graph[i + r + half][j + c + half]
    return new_graph


def melt(graph):
    new_graph = deepcopy(graph)
    for i in range(N):
        for j in range(N):
            if graph[i][j] <= 0:
                continue
            cnt = 0
            for d in directions:
                nr, nc = i + d[0], j + d[1]
                if 0 <= nr < N and 0 <= nc < N and graph[nr][nc] > 0:
                    cnt += 1
            if cnt < 3:
                new_graph[i][j] -= 1
    return new_graph


def get_max_remain_ice(graph):
    max_size = 0
    visited = [[False] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if visited[i][j] or graph[i][j] <= 0:
                continue
            dq = deque([(i, j)])
            visited[i][j] = True
            cnt = 1
            while dq:
                x, y = dq.popleft()
                for dx, dy in directions:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and graph[nx][ny] > 0:
                        dq.append((nx, ny))
                        visited[nx][ny] = True
                        cnt += 1
            max_size = max(max_size, cnt)
    return max_size


def get_remains(graph):
    total = 0
    for row in graph:
        for v in row:
            if v > 0:
                total += v
    return total


for level in levels:
    graph = rotate(graph, level)
    graph = melt(graph)

print(get_remains(graph))
print(get_max_remain_ice(graph))
