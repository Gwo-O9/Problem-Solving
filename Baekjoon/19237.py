N, M, K = map(int, input().split())
shark_infos = []
direction = [[], [-1, 0], [1, 0], [0, -1], [0, 1]]
for i in range(N):
    tmp = list(map(int, input().split()))
    for j in range(N):
        if tmp[j] != 0:
            shark_infos.append([tmp[j], i, j, -1])

shark_infos.sort(key=lambda x: x[0]) # shark_number에 따라 정렬
shark_directions = list(map(int, input().split()))
for i, d in enumerate(shark_directions):
    shark_infos[i][3] = d
priority = [[[0] for _ in range(4)] for _ in range(M)]
smell = [[(0, 0) for _ in range(N)] for _ in range(N)]
# 위, 아래, 왼, 우
for i in range(M):
    for j in range(4):
        priority[i][j] = list(map(int, input().split()))


# 최초 냄새 뿌리기
for shark_info in shark_infos:
    number, x, y, d = shark_info
    smell[x][y] = (number, 0)

time = 1
while True:
    if time > 1000:
        break
    # 이동
    for i, shark_info in enumerate(shark_infos):
        number, x, y, d = shark_info
        candidates = []
        my_smell = []
        for j in range(1, 5):
            nx, ny = x + direction[j][0], y + direction[j][1]
            if 0 <= nx < N and 0 <= ny < N:
                if smell[nx][ny] == (0, 0):
                    candidates.append([j, nx, ny])
                elif smell[nx][ny][0] == number:
                    my_smell.append([j, nx, ny])
        moved = False
        if len(candidates) > 0:
            for k in priority[number-1][d-1]:
                if moved:
                    break
                for candidate in candidates:
                    if k == candidate[0]:
                        shark_infos[i][1], shark_infos[i][2], shark_infos[i][3] = candidate[1], candidate[2], candidate[0]
                        moved = True
                        break
        else:
            for k in priority[number-1][d-1]:
                if moved:
                    break
                for ms in my_smell:
                    if k == ms[0]:
                        shark_infos[i][1], shark_infos[i][2], shark_infos[i][3] = ms[1], ms[2], ms[0]
                        moved = True
                        break

    # 시간 지난 냄새 제거
    for i in range(N):
        for j in range(N):
            if time - smell[i][j][1] == K:
                smell[i][j] = (0, 0)

    # 겹친 거 삭제
    should_remove = []
    for i, shark_info in enumerate(shark_infos):
        for j, shark_info2 in enumerate(shark_infos):
            if i == j:
                continue
            if shark_info[1] == shark_info2[1] and shark_info[2] == shark_info2[2]:
                if shark_info[0] > shark_info2[0]:
                    if shark_info not in should_remove:
                        should_remove.append(shark_info)
                else:
                    if shark_info2 not in should_remove:
                        should_remove.append(shark_info2)

    for i in should_remove:
        shark_infos.remove(i)

    # 냄새 뿌리기
    for shark_info in shark_infos:
        number, x, y, d = shark_info
        smell[x][y] = (number, time)

    if len(shark_infos) == 1:
        break

    time += 1

print(time) if time <= 1000 else print(-1)