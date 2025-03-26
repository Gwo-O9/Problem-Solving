# 1260
from collections import deque
N, M, V = map(int, input().split())

graph = [[0] * (N+1) for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b], graph[b][a] = 1, 1

visited_dfs = [False] * (N+1)
visited_bfs = [False] * (N+1)

def bfs(v):
    q = deque([v])
    visited_bfs[v] = True
    while q:
        v = q.popleft()
        print(v, end=" ")
        for i in range(1, N+1):
            if not visited_bfs[i] and graph[v][i] == 1:
                q.append(i)
                visited_bfs[i] = True

def dfs(v):
    visited_dfs[v] = True
    print(v, end=" ")
    for i in range(1, N+1):
        if not visited_dfs[i] and graph[v][i] == 1:
            dfs(i)


dfs(V)
print()
bfs(V)
