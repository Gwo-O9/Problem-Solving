from collections import deque

graph = [[0 for _ in range(101)] for _ in range(101)]

direction = [[0, 1], [-1, 0], [0, -1], [1, 0]]
n = int(input())

for i in range(n):
    x, y, d, g = map(int, input().split())
    graph[x][y] = 1

    q = deque([d])
    for j in range(g):
        for k in range(len(q) - 1, -1, -1):
            q.append((q[k] + 1) % 4)

    while q:
        next = q.popleft()
        x = x + direction[next][1]
        y = y + direction[next][0]
        if (0 <= x <= 100) and (0 <= y <= 100):
            graph[x][y] = 1

cnt = 0

for i in range(100):
    for j in range(100):
        if graph[i][j] == 1 and graph[i + 1][j] == 1 and graph[i][j + 1] == 1 and graph[i + 1][j + 1] == 1:
            cnt += 1

print(cnt)
