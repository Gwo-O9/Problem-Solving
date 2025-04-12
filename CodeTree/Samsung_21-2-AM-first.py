# 19:00
from collections import deque

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
dice_xy = (0, 0)
# 위, 뒤, 오, 왼, 앞, 아래
dice = [1, 2, 3, 4, 5, 6]
directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
dice_d = 0  # 오른쪽부터 시계 방향


def in_range(number):
    if 0 <= number < n:
        return True
    return False


def turn_dice(dice_d):
    if dice_d == 0:
        return [dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]]
    if dice_d == 1:
        return [dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]]
    if dice_d == 2:
        return [dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]]
    else:
        return [dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]]


def get_score(i, j):
    q = deque([(i, j)])
    value = graph[i][j]
    cnt = 1
    visited = [[False for _ in range(n)] for _ in range(n)]
    visited[i][j] = True
    while q:
        r, c = q.popleft()
        for d in directions:
            nr, nc = r + d[0], c + d[1]
            if in_range(nr) and in_range(nc) and not visited[nr][nc] and value == graph[nr][nc]:
                visited[nr][nc] = True
                q.append((nr, nc))
                cnt += 1
    return cnt * value


def get_dice_d(dice_d, i, j):
    floor_value = dice[5]
    if floor_value > graph[i][j]:
        return (dice_d + 1) % 4
    elif floor_value < graph[i][j]:
        return (dice_d - 1) % 4
    else:
        return dice_d


ans = 0
for _ in range(m):
    r, c = dice_xy
    nr, nc = r + directions[dice_d][0], c + directions[dice_d][1]
    if not in_range(nr) or not in_range(nc):
        dice_d = (dice_d + 2) % 4
        nr, nc = r + directions[dice_d][0], c + directions[dice_d][1]

    dice = turn_dice(dice_d)
    dice_xy = (nr, nc)
    ans += get_score(nr, nc)

    dice_d = get_dice_d(dice_d, nr, nc)

print(ans)


