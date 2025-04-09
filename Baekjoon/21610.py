# 16:44

N, M = map(int, input().split())
directions = [[], [0, -1], [-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1]]
cross_directions = [[-1, -1], [-1, 1], [1, -1], [1, 1]]
clouds = [[N - 1, 0], [N - 1, 1], [N - 2, 0], [N - 2, 1]]
graph = [list(map(int, input().split())) for _ in range(N)]
commands = [list(map(int, input().split())) for _ in range(M)]

for cmd in commands:
    d, s = cmd
    new_clouds = []
    visited = [[False] * N for _ in range(N)]
    for cloud in clouds:
        x, y = cloud
        nx, ny = (x + directions[d][0] * s) % N, (y + directions[d][1] * s) % N
        new_clouds.append([nx, ny])
        visited[nx][ny] = True

    for cloud in new_clouds:
        x, y = cloud
        graph[x][y] += 1

    for cloud in new_clouds:
        x, y = cloud
        cnt = 0
        for cd in cross_directions:
            nx, ny = x + cd[0], y + cd[1]
            if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] > 0:
                cnt += 1
        graph[x][y] += cnt

    clouds.clear()
    for i in range(N):
        for j in range(N):
            if graph[i][j] >= 2 and not visited[i][j]:
                graph[i][j] -= 2
                clouds.append([i, j])

total = 0
for i in range(N):
    for j in range(N):
        total += graph[i][j]
print(total)
