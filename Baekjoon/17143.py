from collections import deque

def change_direction(d):
    if d == 0:
        return 1
    elif d == 1:
        return 0
    elif d == 2:
        return 3
    else:
        return 2

R, C, M = map(int, input().split())
fishes = deque()
directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
fisher = -1
ans = 0
for i in range(M):
    r, c, s, d, z = map(int, input().split())
    fishes.append((r - 1, c - 1, s, d - 1, z))

while fisher <= C:
    fisher += 1
    idx = 0
    # 물고기 잡기
    eaten = False
    duplicate_check = [[-1 for _ in range(C)] for _ in range(R)]
    while idx <= R and not eaten:
        for fish in fishes:
            if fish[0] == idx and fish[1] == fisher:
                ans += fish[4]
                fishes.remove(fish)
                eaten = True
                break
        idx += 1

    # 물고기 이동
    after_move = deque()
    should_check = []
    for fish in fishes:
        r, c, s, d, z = fish
        cycle = (R-1)*2 if d < 2 else (C-1)*2
        new_speed = s % cycle
        for i in range(new_speed):
            r, c = r + directions[d][0], c + directions[d][1]
            if (not (0 <= r < R)) or (not (0 <= c < C)):
                d = change_direction(d)
                r, c = r + 2 * directions[d][0], c + 2 * directions[d][1]
                continue
        if duplicate_check[r][c] > z:
            continue
        else:
            after_move.append((r, c, s, d, z))
            duplicate_check[r][c] = z

    should_remove = []
    for a in after_move:
        r, c, s, d, z = a
        if duplicate_check[r][c] != z:
            should_remove.append(a)
    for b in should_remove:
        after_move.remove(b)
    fishes = after_move

print(ans)
