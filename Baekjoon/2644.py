from collections import deque

n = int(input())

a, b = map(int, input().split())

r = int(input())  # number of relationship

graph = [[False for _ in range(n+1)] for _ in range(n+1)]
visited = [False for _ in range(n+1)]

for _ in range(r):
    x, y = map(int, input().split())
    graph[x][y] = graph[y][x] = True

# tuple -> personal number, chon
q = deque([(a, 0)])
visited[a] = True
answer = []
while q:
    now, chon = q.popleft()
    for i in range(1, n+1):
        if graph[now][i] is True and visited[i] is False:
            visited[i] = True
            if i == b:
                answer.append(chon+1)
            else:
                q.append((i, chon+1))

print(min(answer)) if len(answer) != 0 else print(-1)