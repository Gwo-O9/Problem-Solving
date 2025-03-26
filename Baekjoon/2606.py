from collections import deque

computers = int(input())
viruses = int(input())
graph =  [[False for _ in range(computers+1)] for _ in range(computers+1)]
visited = [False]*(computers+1)

for _ in range(viruses):
    x, y = map(int, input().split())
    graph[x][y] = graph[y][x] = True

def dfs(x):
    visited[x] = True
    for i in range(1, computers+1):
        if graph[x][i] is True and visited[i] is False:
            dfs(i)

dfs(1)
print(sum(visited)-1)