# 0북 1동 2남 3서

N, M = map(int, input().split())
r, c, d = map(int, input().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))
directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
cnt = 0

while True:
    if graph[r][c] == 0:
        graph[r][c] = -1  # -1은 청소된 곳
        cnt += 1

    go = False
    for _ in range(4):
        d = (d + 3) % 4
        dx, dy = directions[d]
        nx, ny = r + dx, c + dy
        if nx > 0 and nx <= N and ny > 0 and ny <= M and graph[nx][ny] == 0:
            r, c = nx, ny
            go = True
            break

    if not go:
        dx, dy = directions[d]
        nx, ny = r - dx, c - dy
        if nx > 0 and nx <= N and ny > 0 and ny <= M and graph[nx][ny] != 1:
            r, c = nx, ny
        else:
            break

print(cnt)
