from collections import deque
N, L, R = map(int, input().split())
nations = [list(map(int, input().split())) for _ in range(N)]
directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

def check_diff_in_range(a, b):
    global L, R
    return True if L <= abs(a-b) <= R else False

def bfs(r, c, opened):
    global nations
    q = deque([(r, c, nations[r][c])])
    ret = [(r, c, nations[r][c])] # 연합 (큐에서 빠지면 안되니까)
    while q:
        x, y, value = q.popleft()
        for i in range(4):
            nx, ny = x + directions[i][0], y + directions[i][1]
            if (0 <= nx < N) and (0 <= ny < N) and not opened[nx][ny]:
                if check_diff_in_range(nations[x][y], nations[nx][ny]):
                    q.append((nx, ny, nations[nx][ny]))
                    opened[nx][ny] = True
                    ret.append((nx, ny, nations[nx][ny]))
    return ret


time = 0
while True:
    q = deque((0, 0, nations[0][0]))
    opened = [[False for _ in range(N)] for _ in range(N)]
    should_end = True
    for i in range(N):
        for j in range(N):
            if not opened[i][j]:
                opened[i][j] = True
                ret = bfs(i, j, opened)
                if len(ret) > 1:
                    should_end = False
                    adjusted_population = sum(x for _, _, x in ret) // len(ret)
                    for x, y, _ in ret:
                        nations[x][y] = adjusted_population
    if should_end: break
    time += 1

print(time)



