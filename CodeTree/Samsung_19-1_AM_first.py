n, m, t = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
directions = [[0, 1], [-1, 0], [0, -1], [1, 0]]

wind = []

for i in range(n):
    for j in range(m):
        if graph[i][j] == -1:
            wind.append((i, j))

for _ in range(t):
    should_add = [[0 for _ in range(m)] for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if graph[i][j] == -1: continue
            amount = graph[i][j] // 5
            for d in directions:
                nr, nc = i + d[0], j + d[1]
                if 0 <= nr < n and 0 <= nc < m and graph[nr][nc] != -1:
                    should_add[nr][nc] += amount
                    should_add[i][j] -= amount

    for i in range(n):
        for j in range(m):
            graph[i][j] += should_add[i][j]

    up_x, up_y = wind[0]
    down_x, down_y = wind[1]
    d = 1
    # 위 (반대로 추적, 위로 출발)
    # 반시계: 0 오 1 위 2 왼 3 아
    while True:
        nr, nc = up_x + directions[d][0], up_y + directions[d][1]
        if not (0 <= nr < n and 0 <= nc < m) or (nr == wind[1][0]):
            d = (d - 1) % 4
            continue
        if graph[nr][nc] == -1:
            graph[up_x][up_y] = 0
            break
        if graph[up_x][up_y] == -1:
            up_x, up_y = nr, nc
            continue
        graph[up_x][up_y] = graph[nr][nc]
        up_x, up_y = nr, nc

    # 아래
    d = 3
    while True:
        nr, nc = down_x + directions[d][0], down_y + directions[d][1]
        if not (0 <= nr < n and 0 <= nc < m) or nr == wind[0][0]:
            d = (d + 1) % 4
            continue
        if graph[nr][nc] == -1:
            graph[down_x][down_y] = 0
            break
        if graph[down_x][down_y] == -1:
            down_x, down_y = nr, nc
            continue
        graph[down_x][down_y] = graph[nr][nc]
        down_x, down_y = nr, nc

total = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] >= 0:
            total += graph[i][j]

print(total)