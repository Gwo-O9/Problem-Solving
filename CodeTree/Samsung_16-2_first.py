n, m, x, y, k = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
cmds = list(map(int, input().split()))
directions = [[], [0, 1], [0, -1], [-1, 0], [1, 0]]
dice = [0, 0, 0, 0, 0, 0] #상, 하, 좌, 우, 앞, 뒤

# 동, 서, 북, 남
def turn_dice(dice, d):
    if d == 1: # 동
        return [dice[2], dice[3], dice[1], dice[0], dice[4], dice[5]]
    if d == 2: # 서
        return [dice[3], dice[2], dice[0], dice[1], dice[4], dice[5]]
    if d == 3: # 북
        return [dice[5], dice[4], dice[2], dice[3], dice[0], dice[1]]
    else: # 남
        return [dice[4], dice[5], dice[2], dice[3], dice[1], dice[0]]

for d in cmds:
    # 아랫면은 dice[1]
    nx, ny = x + directions[d][0], y + directions[d][1]
    if 0 <= nx < n and 0 <= ny < m:
        dice = turn_dice(dice, d)
        if graph[nx][ny] == 0:
            graph[nx][ny] = dice[1]
        else:
            dice[1] = graph[nx][ny]
            graph[nx][ny] = 0
        print(dice[0])
        x, y = nx, ny