from collections import deque


def change_direction(d):
    if d == 1:
        return 2
    elif d == 2:
        return 1
    elif d == 3:
        return 4
    else:
        return 3

N, K = map(int, input().split())
color = [[0] * (N + 1)]
for _ in range(N):
    color.append([0] + list(map(int, input().split())))  # 0: 흰, 1: 빨강, 2: 파랑

# 방향 정보 (1:오른쪽, 2:왼쪽, 3:위, 4:아래)
direction = [[], [0, 1], [0, -1], [-1, 0], [1, 0]]  # index 0은 dummy

chess_pieces = [list(map(int, input().split())) for _ in range(K)]

# 보드 위의 말 쌓기 정보
graph = [[deque() for _ in range(N + 1)] for _ in range(N + 1)]
for i in range(K):
    r, c, _ = chess_pieces[i]
    graph[r][c].append(i)


# 말 이동 함수
def move_piece(i, r, c, nr, nc, color_type):
    idx = graph[r][c].index(i)
    moving = list(graph[r][c])[idx:]
    graph[r][c] = deque(list(graph[r][c])[:idx])

    if color_type == 1:
        moving.reverse()

    for m in moving:
        chess_pieces[m][0] = nr
        chess_pieces[m][1] = nc
        graph[nr][nc].append(m)


time = 0
while True:
    time += 1
    if time > 1000:
        print(-1)
        break

    for i in range(K):
        r, c, d = chess_pieces[i]
        dr, dc = direction[d]
        nr, nc = r + dr, c + dc

        # 이동할 수 없거나 파란색
        if not (1 <= nr <= N and 1 <= nc <= N) or color[nr][nc] == 2:
            d = change_direction(d)
            chess_pieces[i][2] = d
            dr, dc = direction[d]
            nr, nc = r + dr, c + dc
            # 방향 바꿔도 못가면 skip
            if not (1 <= nr <= N and 1 <= nc <= N) or color[nr][nc] == 2:
                continue

        move_piece(i, r, c, nr, nc, color[nr][nc])

        # 이동 직후 말이 4개 이상 쌓였는지 체크
        if len(graph[nr][nc]) >= 4:
            print(time)
            exit()
