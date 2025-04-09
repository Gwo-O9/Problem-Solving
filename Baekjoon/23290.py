import copy
from collections import deque

M, S = map(int, input().split())
graph = [[[] for _ in range(4)] for _ in range(4)]
for _ in range(M):
    r, c, d = map(int, input().split())
    graph[r-1][c-1].append(d-1)
shark_x, shark_y = map(int, input().split())
shark = [shark_x - 1, shark_y - 1]
directions = [[0, -1], [-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1]]
four_directions = [[-1, 0], [0, -1], [1, 0], [0, 1]]
smell = [[0 for _ in range(4)] for _ in range(4)]



def shark_move(candidate, r, c, cnt):  # dfs
    global max_eaten, path, shark
    if len(candidate) == 3:
        if max_eaten < cnt:
            max_eaten = cnt
            path = candidate[:]
        return

    for d in four_directions:
        nr, nc = r + d[0], c + d[1]
        if 0 <= nr < 4 and 0 <= nc < 4:
            new_eaten = len(new_graph[nr][nc]) if (nr, nc) not in candidate else 0
            candidate.append((nr, nc))
            shark_move(candidate, nr, nc, cnt + new_eaten)
            candidate.pop()


for _ in range(S):
    # 물고기 이동
    base_graph = copy.deepcopy(graph)
    new_graph = [[[] for _ in range(4)] for _ in range(4)]

    for i in range(4):
        for j in range(4):
            for fish in graph[i][j]:
                nr, nc = i, j
                origin_d = fish
                moved = False
                for _ in range(8):
                    nr, nc = i + directions[fish][0], j + directions[fish][1]
                    if 0 <= nr < 4 and 0 <= nc < 4 and not (shark[0] == nr and shark[1] == nc) and smell[nr][nc] == 0:
                        moved = True
                        break
                    else:
                        fish = (fish - 1) % 8
                if not moved:
                    nr, nc = i, j
                    fish = origin_d
                new_graph[nr][nc].append(fish)

    # 상어 3칸 이동
    path = []
    max_eaten = -1
    shark_move([], shark[0], shark[1], 0)

    shark = list(path[-1])

    for x, y in path:
        if new_graph[x][y]:
            new_graph[x][y] = []
            smell[x][y] = 3

    # 냄새 제거 - 도 없는 냄새
    for i in range(4):
        for j in range(4):
            if smell[i][j] > 0:
                smell[i][j] -= 1

    # 복제 마법
    for i in range(4):
        for j in range(4):
            new_graph[i][j] += base_graph[i][j]

    graph = new_graph

remains = 0
for i in range(4):
    for j in range(4):
        remains += len(graph[i][j])

print(remains)
