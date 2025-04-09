from collections import deque

dice = [1, 2, 3, 4, 5, 6] # [상, 북, 동, 서, 남, 하]
dice_x, dice_y = 0, 0
directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
d = 0
score = 0

def turn(dice, dir):
    top, north, east, west, south, bottom = dice
    if dir == 0:  # 동
        return [west, north, top, bottom, south, east]
    elif dir == 1:  # 남
        return [north, bottom, east, west, top, south]
    elif dir == 2:  # 서
        return [east, north, bottom, top, south, west]
    elif dir == 3:  # 북
        return [south, top, east, west, bottom, north]


N, M, K = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
score_map = [[0] * M for _ in range(N)]

def get_cnt(x, y, value):
    global score_map
    if score_map[x][y] != 0:
        return score_map[x][y]
    q = deque([(x, y)])
    visited = [[False for _ in range(M)] for _ in range(N)]
    visited[x][y] = True
    region = [(x, y)]
    cnt = 1
    while q:
        r, c = q.popleft()
        for d in directions:
            nr, nc = r + d[0], c + d[1]
            if 0 <= nr < N and 0 <= nc < M and graph[nr][nc] == value and not visited[nr][nc]:
                q.append((nr, nc))
                region.append((nr, nc))
                visited[nr][nc] = True
                cnt += 1
    score = value * cnt
    for i, j in region:
        score_map[i][j] = score
    return score

for _ in range(K):
    nx, ny = dice_x + directions[d][0], dice_y + directions[d][1]
    if not (0 <= nx < N and 0 <= ny < M):
        d = (d + 2) % 4
        nx, ny = dice_x + directions[d][0], dice_y + directions[d][1]

    dice = turn(dice, d)
    A = dice[5]
    B = graph[nx][ny]

    # 점수 획득
    score += get_cnt(nx, ny, B)

    if A > B:
        d = (d + 1) % 4
    elif A < B:
        d = (d - 1) % 4
    dice_x, dice_y = nx, ny

print(score)
