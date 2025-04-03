dice = [0, 0, 0, 0, 0, 0, 0]  # 다이스 추적 해야 함


def turn(dice, op):
    dummy, a, b, c, d, e, f = dice
    new_dice = []
    if op == 1:  # 동
        new_dice = [0, dice[3], dice[2], dice[6], dice[1], dice[5], dice[4]]
    elif op == 2:  # 서
        new_dice = [0, dice[4], dice[2], dice[1], dice[6], dice[5], dice[3]]
    elif op == 3:  # 북
        new_dice = [0, dice[2], dice[6], dice[3], dice[4], dice[1], dice[5]]
    else:  # 남
        new_dice = [0, dice[5], dice[1], dice[3], dice[4], dice[6], dice[2]]
    return new_dice


N, M, x, y, K = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
ops = list(map(int, input().split()))

directions = [[], [0, 1], [0, -1], [-1, 0], [1, 0]]

for op in ops:
    nx = x + directions[op][0]
    ny = y + directions[op][1]

    if not (0 <= nx < N) or not (0 <= ny < M):
        continue
    dice = turn(dice, op)
    x, y = nx, ny

    if graph[nx][ny] == 0:
        graph[nx][ny] = dice[1]
        print(dice[6])

    else:
        dice[1] = graph[nx][ny]
        graph[nx][ny] = 0
        print(dice[6])