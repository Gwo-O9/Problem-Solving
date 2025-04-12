# 17:26
from collections import deque

# ipunt ##############################
L, N, Q = map(int, input().split())
# 0 빈칸, 1 함정, 2 벽
graph = [list(map(int, input().split())) for _ in range(L)]
# (r, c), 좌측 상단 꼭지점 기준 세로 h, 가로 w, 초기 체력 k
soldiers = [list(map(int, input().split())) for _ in range(N)]
for s in soldiers: # 0-based
    s[0] -= 1
    s[1] -= 1
commands = [list(map(int, input().split())) for _ in range(Q)]
for c in commands: #0-based
    c[0] -= 1
intent_health = [k for _,_,_,_,k in soldiers]
directions = [[-1, 0], [0, 1], [1, 0], [0, -1]] # 위 오른 아래 왼
# input ##############################

# Q개 명령 진행 후 생존 기사들이 총 받은 데미지

def in_range(number):
    if 0 <= number < L:
        return True
    return False


def try_move(cmd) -> tuple[bool, list[bool]]:
    is_moved = [False for _ in range(N)]
    idx, d = cmd
    if soldiers[idx][4] <= 0:
        return False, is_moved
    is_moved[idx] = True
    q = deque([idx])
    dx, dy = directions[d]
    while q:
        x = q.popleft()
        r, c, h, w, _ = soldiers[x]
        nr, nc = r + dx, c + dy
        if not (in_range(nr) and in_range(nc) and in_range(nr + h - 1) and in_range(nc + w - 1)):
            return False, is_moved

        for i in range(nr, nr + h):
            for j in range(nc, nc + w):
                if graph[i][j] == 2:
                    return False, is_moved

        for i in range(N):
            if is_moved[i] or soldiers[i][4] <= 0:  # 이미 움직였거나 체력이 0
                continue
            if soldiers[i][0] > nr + h - 1 or nr > soldiers[i][0] + soldiers[i][2] - 1:
                continue
            if soldiers[i][1] > nc + w - 1 or nc > soldiers[i][1] + soldiers[i][3] - 1:
                continue

            is_moved[i] = True
            q.append(i)
    return True, is_moved


def move(moved_info, cmd):
    id, dir = cmd
    if soldiers[id][4] <= 0:
        return
    for idx, m in enumerate(moved_info):
        if m:  # 움직였으면
            soldiers[idx][0] += directions[dir][0]
            soldiers[idx][1] += directions[dir][1]

            if id == idx:
                continue
            # 데미지 입음
            r, c, h, w, _ = soldiers[idx]
            for i in range(r, r + h):
                for j in range(c, c + w):
                    if graph[i][j] == 1 and soldiers[idx][4] > 0:
                        soldiers[idx][4] -= 1


for cmd in commands:
    ok, moved_info = try_move(cmd)

    if ok:
        move(moved_info, cmd)

ans = 0
for idx, soldier in enumerate(soldiers):
    if soldier[4] <= 0:
        continue
    else:
        ans += (intent_health[idx] - soldier[4])

print(ans)

