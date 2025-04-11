N = int(input())

graph = [list(map(int, input().split())) for _ in range(N)]

left = [[-1, 0, 0.07], [-2, 0, 0.02], [1, 0, 0.07], [2, 0, 0.02], [0, -2, 0.05], [-1, -1, 0.1], [1, -1, 0.1], [1, 1, 0.01], [-1, 1, 0.01]]
right = [[x, -y, z] for x, y, z in left]
up = [[y, -x, z] for x, y, z in left]
down = [[-y, x, z] for x, y, z in left]
sand_directions = [left, down, right, up]
direction = [[0, -1], [1, 0], [0, 1],[-1, 0]]
x = N // 2
y = N // 2
disappeared_sand = 0

# 방향 전환을 위해
d = 0
change_direction = 1
change_direction_count = 0
cnt = 0

while True:
    if x == 0 and y == 0:
        break
    cnt += 1
    nx, ny = x + direction[d][0], y + direction[d][1]
    cur_sand = int(graph[nx][ny])
    moved_sand = 0

    # 비율별로 모래 이동
    for sand_direction in sand_directions[d]:
        dx, dy, rate = sand_direction
        nnx, nny = nx + dx, ny + dy
        moving_sand = int(cur_sand * rate)
        if 0 <= nnx < N and 0 <= nny < N:
            graph[nnx][nny] += moving_sand
        else:
            disappeared_sand += moving_sand
        moved_sand += moving_sand

    # 앞앞칸
    nnx, nny = nx + direction[d][0], ny + direction[d][1]
    remain_sand = cur_sand - moved_sand
    if 0 <=  nnx < N and 0 <=  nny < N:
        graph[nnx][nny] += remain_sand
    else:
        disappeared_sand += remain_sand
    # 앞칸
    graph[nx][ny] = 0

    if cnt == change_direction:
        d = (d+1)%4
        cnt = 0
        change_direction_count += 1
    if change_direction_count == 2:
        change_direction += 1
        change_direction_count = 0
    x, y = nx, ny

print(disappeared_sand)

