from collections import deque

N, M = map(int, input().split())
graph = []
rx, ry, bx, by = 0, 0, 0, 0
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for i in range(N):
    graph.append(list(input()))
    for j in range(M):
        if graph[i][j] == 'R':
            rx, ry = i, j
        if graph[i][j] == 'B':
            bx, by = i, j

def bfs(rx, ry, bx, by):
    q = deque([(rx, ry, bx, by)])
    visited = set()
    count = 0
    while q:
        for _ in range(len(q)): # queue에 있는 걸 한바퀴 돌려야 count임
            rx, ry, bx, by = q.popleft()
            visited.add((rx, ry, bx, by))
            if count > 10:
                print(-1)
                return
            if graph[rx][ry] == 'O':
                print(count)
                return
            for i in range(4):
                # 빨간 구슬
                rnx, rny = rx, ry
                while True:
                    rnx, rny = rnx + dx[i], rny + dy[i]
                    if graph[rnx][rny] == '#': # 벽이면 한칸 뒤로 다시 이동
                        rnx, rny = rnx - dx[i], rny - dy[i]
                        break
                    if graph[rnx][rny] == 'O': # 구멍 골인
                        break
                # 파란 구슬
                bnx, bny = bx, by
                while True:
                    bnx, bny = bnx + dx[i], bny + dy[i]
                    if graph[bnx][bny] == '#': # 벽이면 한칸 뒤로 다시 이동
                        bnx, bny = bnx - dx[i], bny - dy[i]
                        break
                    if graph[bnx][bny] == 'O': # 구멍 골인
                        break
                if graph[bnx][bny] == 'O': # 파란 구슬은 들어가면 안되니까 패스
                    continue
                if rnx == bnx and rny == bny:
                    if abs(rnx - rx) + abs(rny - ry) > abs(bnx - bx) + abs(bny - by):
                        rnx, rny = rnx - dx[i], rny - dy[i]
                    else:
                        bnx, bny = bnx - dx[i], bny - dy[i]
                if (rnx, rny, bnx, bny) not in visited:
                    q.append((rnx, rny, bnx, bny))
                    visited.add((rnx, rny, bnx, bny))
        count += 1
    print(-1)

bfs(rx, ry, bx, by)