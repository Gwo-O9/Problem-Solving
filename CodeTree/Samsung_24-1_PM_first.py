from collections import deque

R, C, K = map(int, input().split())
graph = [[0 for _ in range(C)] for _ in range(R)]
golems = [list(map(int, input().split())) for _ in range(K)]
for g in golems:
    g[0] -= 1
directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
score = 0


def in_range(r, c):
    if 0 <= r < R and 0 <= c < C:
        return True
    else:
        return False


def check_4_directions(r, c):
    for d in directions:
        nr, nc = r + d[0], c + d[1]
        if nr <= -1:
            continue
        if not in_range(nr, nc) or graph[nr][nc] != 0:
            return False
    return True

def check_out(r, c):
    for d in directions:
        nr, nc = r + d[0], c + d[1]
        if not in_range(nr, nc) or graph[nr][nc] != 0:
            return False
    return True


def move(idx, golem):
    global score, graph
    start_c, exit_d = golem
    r, c = -2, start_c
    nr, nc = r, c

    while True:
        # 아래로 내려감
        if check_4_directions(nr + 1, nc):
            nr += 1
            continue

        if check_4_directions(nr , nc - 1):
            if check_4_directions(nr + 1, nc - 1):
                nr += 1
                nc -= 1
                exit_d = (exit_d - 1) % 4
                continue

        if check_4_directions(nr, nc + 1):
            if check_4_directions(nr + 1, nc + 1):
                nr += 1
                nc += 1
                exit_d = (exit_d + 1) % 4
                continue

        break

    # 다 내려왔는데 범위 밖이면 비우고 종료
    if check_out(nr, nc) is False:
        for i in range(R):
            for j in range(C):
                graph[i][j] = 0
        return

    # 내려갈 곳이 없음
    graph[nr][nc] = idx
    for d_idx, d in enumerate(directions):
        nnr, nnc = nr + d[0], nc + d[1]
        if d_idx == exit_d:
            graph[nnr][nnc] = 10000 + idx # 출구는 10,000 + idx로 표기
        else:
            graph[nnr][nnc] = idx

    # 점수 구해야 함
    max_depth = nr + 1
    q = deque([(nr, nc)])
    visited = [[False for _ in range(C)] for _ in range(R)]
    visited[nr][nc] = 0
    while q:
        x, y = q.popleft()
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if in_range(nx, ny) and not visited[nx][ny]:
                if graph[x][y] == graph[nx][ny] or graph[nx][ny] == 10000 + graph[x][y] or graph[x][y] == graph[nx][ny] + 10000:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    max_depth = max(nx + 1, max_depth)
                elif graph[x][y] > 10000: # 출구에 서있을 때
                    if graph[nx][ny] > 0:
                        q.append((nx, ny))
                        visited[nx][ny] = True
                        max_depth = max(nx + 1, max_depth)
                # 1. 출구를 포함한 같은 숫자 내로 자유롭게 이동
                # 2. 출구에 서있다면 -> 다음 칸이 0보다 크면 이동 가능
    score += max_depth


for i, g in enumerate(golems):
    move(i + 1, g)

print(score)
