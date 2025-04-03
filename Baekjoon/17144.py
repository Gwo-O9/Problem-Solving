R, C, T = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(R)]
cleaner = []
direction = [[-1, 0], [0, 1], [1, 0], [0, -1]]
for i in range(R):
    for j in range(C):
        if (graph[i][j]) == -1:
            cleaner.append((i, j))
# NOTE: cleaner[0] -> 공기청정기 위쪽 좌표, cleaner[1] -> 공기 청정기 아래쪽 좌표

def blow():
    global R, C, graph
    add_amount = [[0 for _ in range(C)] for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if graph[i][j] > 0:
                for d in range(4):
                    nr, nc = i + direction[d][0], j + direction[d][1]
                    if (0 <= nr < R) and (0 <= nc < C) and graph[nr][nc] != -1:
                        add_amount[nr][nc] += (graph[i][j] // 5)
                        add_amount[i][j] -= (graph[i][j] // 5)

    for i in range(R):
        for j in range(C):
            if graph[i][j] != -1:
                graph[i][j] += add_amount[i][j]

def clean():
    global direction, graph
    x, y = cleaner[0]
    y += 1
    d = 1
    tmp = 0
    while True:
        nx, ny = x + direction[d][0], y + direction[d][1]
        if nx == R or ny == C or nx == -1 or ny == -1:
            d = (d-1) % 4
            continue
        if x == cleaner[0][0] and y == cleaner[0][1]:
            break
        graph[x][y], tmp = tmp, graph[x][y]
        x, y = nx, ny
    d = 1
    tmp = 0
    x, y = cleaner[1]
    y += 1
    while True:
        nx, ny = x + direction[d][0], y + direction[d][1]
        if nx == R or ny == C or nx == -1 or ny == -1:
            d = (d+1) % 4
            continue
        if x == cleaner[1][0] and y == cleaner[1][1]:
            break
        graph[x][y], tmp = tmp, graph[x][y]
        x, y = nx, ny

for _ in range(T):
    blow()
    clean()

ans = 0
for i in range(R):
    for j in range(C):
        ans += graph[i][j]

ans -= (graph[cleaner[0][0]][cleaner[0][1]] + graph[cleaner[1][0]][cleaner[1][1]])
print(ans)



