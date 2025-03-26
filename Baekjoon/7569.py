from collections import deque

M, N, H = map(int, input().split())

tomatoes = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

dx = [0, 0, 0, 0, 1, -1]
dy = [0, 0, 1, -1, 0, 0]
dz = [1, -1, 0, 0, 0, 0]

expected_cnt = 0
ans_time = 0
q = deque()
cnt = 0
for i in range(H):
    for j in range(N):
        for k in range(M):
            if tomatoes[i][j][k] == 0:
                expected_cnt += 1
            if tomatoes[i][j][k] == 1:
                q.append((i, j, k, 0))


while q:
    x,y,z,time = q.popleft()
    for i in range(6):
        nx, ny, nz = x + dx[i], y + dy[i], z + dz[i]
        if nx < 0 or nx >= H or ny < 0 or ny >= N or nz < 0 or nz >= M:
            continue
        if tomatoes[nx][ny][nz] == 0:
            tomatoes[nx][ny][nz] = 1
            q.append((nx, ny, nz, time+1))
            cnt += 1
            ans_time = max(ans_time, time+1)

print(ans_time) if cnt == expected_cnt else print(-1)