import sys
sys.setrecursionlimit(10**5)

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [0]*(n+1)
cnt = 1

def dfs(i):
    global cnt

    visited[i] = cnt
    cnt += 1
    graph[i].sort(reverse=True)
    for k in graph[i]:
        if visited[k] == 0:
            visited[k] = cnt
            dfs(k)


dfs(r)

for i in visited[1:]:
    print(i)
