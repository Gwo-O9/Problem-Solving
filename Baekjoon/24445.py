from collections import deque

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [0]*(n+1)
q = deque()
q.append(r)
visited[r] = 1
cnt = 2
while q:
    x = q.popleft()
    graph[x].sort(reverse=True)
    for i in graph[x]:
        if visited[i] == 0:
            visited[i] = cnt
            cnt += 1
            q.append(i)

for i in visited[1:]:
    print(i)

