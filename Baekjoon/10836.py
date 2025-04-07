m, n = map(int, input().split())
growth = [1] * (2*m-1)
graph = [[0 for _ in range(m)] for _ in range(m)]

for _ in range(n):
    x, y, z = map(int, input().split())
    idx = 0
    for _ in range(x):
        idx += 1
    for _ in range(y):
        growth[idx] += 1
        idx += 1
    for _ in range(z):
        growth[idx] += 2
        idx += 1

idx = 0
for i in range(m-1, -1, -1):
    graph[i][0] = growth[idx]
    idx += 1

for i in range(1, m):
    for j in range(0, m):
        graph[j][i] = growth[idx]
    idx += 1

for i in range(m):
    for j in range(m):
        print(graph[i][j], end=' ')
    print()
