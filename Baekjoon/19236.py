import copy

graph = []
fish_info = [[True, 0, 0, 0] for _ in range(16)]
directions = [[-1, 0], [-1, -1], [0, -1], [1, -1], [1, 0], [1, 1], [0, 1], [-1, 1]]
ans = 0
for i in range(4):
    tmp = list(map(int, input().split()))
    fishes = []
    for j in range(4):
        fishes.append((tmp[j*2]-1, tmp[j*2+1]-1))
    graph.append(fishes)

for i in range(4):
    for j in range(4):
        fish_info[graph[i][j][0]] = [True, i, j, graph[i][j][1]]

def dfs(tmp_graph, score, shark, tmp_fish_info):
    global ans
    graph = copy.deepcopy(tmp_graph)
    fish_info = copy.deepcopy(tmp_fish_info)
    shark_x, shark_y = shark
    fish_num = graph[shark_x][shark_y][0]
    score += fish_num + 1
    d = fish_info[fish_num][3]
    fish_info[fish_num][0] = False

    for i, (alive, fish_x, fish_y, fish_d) in enumerate(fish_info):
        if not alive:
            continue
        for j in range(8):
            dir = (fish_d+j) % 8
            nx, ny = fish_x + directions[dir][0], fish_y + directions[dir][1]
            if 0 <= nx < 4 and 0 <= ny < 4 and (nx, ny) != shark:
                n_fish_info = fish_info[graph[nx][ny][0]]
                graph[fish_x][fish_y], graph[nx][ny] = graph[nx][ny], graph[fish_x][fish_y]
                n_fish_info[1], n_fish_info[2] = fish_x, fish_y
                fish_info[i][1], fish_info[i][2] = nx, ny
                fish_info[i][3] = dir
                break

    candidates = []
    for _ in range(3):
        shark_x = shark_x + directions[d][0]
        shark_y = shark_y + directions[d][1]
        if 0 <= shark_x < 4 and 0 <= shark_y < 4 and fish_info[graph[shark_x][shark_y][0]][0] is True:
            candidates.append((shark_x, shark_y))
    if len(candidates) == 0:
        ans = max(ans, score)
        return
    else:
        for candidate in candidates:
            dfs(graph, score, candidate, fish_info)



dfs(graph, 0, (0,0), fish_info)
print(ans)