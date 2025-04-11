n, m, k, c = map(int, input().split()) # 확산범위 k, 유지 년 c
graph = [list(map(int, input().split())) for _ in range(n)]
directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
cross_directions = [[-1, -1], [1, 1], [-1, 1], [1, -1]]
drugs = [[0 for _ in range(n)] for _ in range(n)]

def grow():
    global graph
    should_add = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if graph[i][j] > 0:
                cnt = 0
                for d in directions:
                    nx, ny = i + d[0], j + d[1]
                    if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] > 0:
                        cnt += 1
                should_add[i][j] += cnt

    for i in range(n):
        for j in range(n):
            graph[i][j] += should_add[i][j]

def move():
    global graph
    should_add = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if graph[i][j] > 0:
                candidates = []
                cnt = 0
                for d in directions:
                    nx, ny = i + d[0], j + d[1]
                    if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 0 and drugs[nx][ny] == 0:
                        cnt += 1
                        candidates.append((nx, ny))
                if cnt > 0:
                    for x, y in candidates:
                        should_add[x][y] += (graph[i][j] // cnt)

    for i in range(n):
        for j in range(n):
            graph[i][j] += should_add[i][j]

def use_drug_with_rollback(i, j):
    if graph[i][j] == 0:
        return 0
    cnt = graph[i][j]
    for d in cross_directions:
        nx, ny = i, j
        for _ in range(k):
            nx += d[0]
            ny += d[1]
            if 0 <= nx < n and 0 <= ny < n:
                if graph[nx][ny] in [-1, 0]:
                    break
                else:
                    cnt += graph[nx][ny]
            else:
                break

    return cnt



def get_drug_site():
    max_cnt = -1
    (x, y) = (-1, -1)
    for i in range(n):
        for j in range(n):
            if graph[i][j] >= 0:
                now_cnt = use_drug_with_rollback(i, j)
                if max_cnt < now_cnt:
                    max_cnt = now_cnt
                    (x, y) = (i, j)
    return x, y

def use_drug(i, j):
    drugs[i][j] = c
    if graph[i][j] == 0:
        return 0
    cnt = graph[i][j]
    graph[i][j] = 0
    for d in cross_directions:
        nx, ny = i, j
        for _ in range(k):
            nx += d[0]
            ny += d[1]
            if 0 <= nx < n and 0 <= ny < n:
                if graph[nx][ny] == -1:
                    break
                elif graph[nx][ny] == 0:
                    drugs[nx][ny] = c
                    break
                else:
                    drugs[nx][ny] = c
                    cnt += graph[nx][ny]
                    graph[nx][ny] = 0
    return cnt

def minus_drug():
    for i in range(n):
        for j in range(n):
            if drugs[i][j] > 0:
                drugs[i][j] -= 1

total = 0
for _ in range(m):
    grow()
    move()
    minus_drug()
    x, y = get_drug_site()
    total += use_drug(x, y)

print(total)