import copy
import sys
import copy
input = lambda: sys.stdin.readline().rstrip()
directions = [[-1, 0], [-1, -1], [0, -1], [1, -1], [1, 0], [1, 1], [0, 1], [-1, 1]]
x, y = 0, 0
fishes = [[0]*4 for _ in range(4)]
ans = 0

for i in range(4):
    l = list(map(int, input().split()))
    for j in range(4):
        fishes[i][j] = [l[j*2], l[j*2+1]-1]

def find_fish(graph, index):
    for i in range(4):
        for j in range(4):
            if graph[i][j][0] == index:
                return [i,j]
    return None

def dfs(shark_x, shark_y, eat, graph):
    global ans
    graph = copy.deepcopy(graph)

    eat += graph[shark_x][shark_y][0] # 현재 좌표 물고기의 번호
    graph[shark_x][shark_y][0] = -1

    # 물고기 회전
    for i in range(1, 17):
        position = find_fish(graph, i)
        if position != None:
            x,y = position[0], position[1]
            direction = graph[x][y][1]
            for j in range(8):
                nx, ny = x + directions[direction][0], y + directions[direction][1]
                if 0 <= nx < 4 and 0 <= ny <4:
                    if not (shark_x == nx and shark_y == ny):
                        graph[x][y][1] = direction
                        graph[x][y], graph[nx][ny] = graph[nx][ny], graph[x][y]
                        break
                direction = (direction + 1) % 8

    positions = []

    # 이동 가능한 위치 담기
    d = graph[shark_x][shark_y][1]
    for i in range(4):
        shark_x += directions[d][0]
        shark_y += directions[d][1]

        if 0 <= shark_x < 4 and 0 <= shark_y < 4 and graph[shark_x][shark_y][0] != -1:
            positions.append([shark_x,shark_y])

    if len(positions) == 0:
        ans = max(ans, eat)
        return

    for xy in positions:
        dfs(xy[0], xy[1], eat, graph)


dfs(0,0,0, fishes)
print(ans)
