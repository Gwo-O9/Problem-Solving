#  #################### input ####################################
N, M, K = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
people = [list(map(lambda x: int(x) - 1, input().split())) for _ in range(M)]
exit_rc = list(map(lambda x: int(x) - 1, input().split()))
# 상, 좌, 하, 우
directions = [[-1, 0], [0, -1], [1, 0], [0, 1]]
#  #################### input ####################################

def move():
    global people, moving_distance
    new_people = []
    for r, c in people:
        if [r, c] == exit_rc:
            continue

        # 출구 좌표
        ex, ey = exit_rc

        # 행이 다르면 우선 행 이동
        if r != ex:
            nr, nc = r, c
            if ex > r:
                nr += 1
            else:
                nr -= 1
            if 0 <= nr < N and graph[nr][nc] == 0:
                new_people.append([nr, nc])
                moving_distance += 1
                continue
        # 행이 같거나 행 이동이 불가능하면 열 이동
        if c != ey:
            nr, nc = r, c
            if ey > c:
                nc += 1
            else:
                nc -= 1
            if 0 <= nc < N and graph[nr][nc] == 0:
                new_people.append([nr, nc])
                moving_distance += 1
                continue
        new_people.append([r, c])
    people[:] = [p for p in new_people if p != exit_rc]


def get_square():
    exit_r, exit_c = exit_rc
    for size in range(1, N + 1):
        for i in range(N - size + 1):
            for j in range(N - size + 1):
                if not (i <= exit_r < i + size and j <= exit_c < j + size):
                    continue
                for p_r, p_c in people:
                    if i <= p_r < i + size and j <= p_c < j + size:
                        return [i, j, size]
    return None

def rotate_90(i, j, size):
    global graph, people, exit_rc

    # graph 회전
    temp = [row[:] for row in graph]
    for r in range(size):
        for c in range(size):
            graph[i + c][j + size - 1 - r] = temp[i + r][j + c]

    # 출구 회전
    ex_r, ex_c = exit_rc
    if i <= ex_r < i + size and j <= ex_c < j + size:
        # 상대 좌표에서 90도 시계회전: (r, c) -> (c, size-1-r)
        rel_r, rel_c = ex_r - i, ex_c - j
        new_r = i + rel_c
        new_c = j + size - 1 - rel_r
        exit_rc[0], exit_rc[1] = new_r, new_c

    # 사람들 회전
    for idx, (p_r, p_c) in enumerate(people):
        if i <= p_r < i + size and j <= p_c < j + size:
            rel_r, rel_c = p_r - i, p_c - j
            new_r = i + rel_c
            new_c = j + size - 1 - rel_r
            people[idx] = [new_r, new_c]

    for r in range(i, i + size):
        for c in range(j, j + size):
            if graph[r][c] > 0:
                graph[r][c] -= 1

time = 0
moving_distance = 0

while time < K and people:
    move()
    sq = get_square()
    if not sq:
        break
    x, y, size = sq
    rotate_90(x, y, size)
    time += 1

print(moving_distance)
print(exit_rc[0] + 1, exit_rc[1] + 1)  # 1-based 좌표 출력
