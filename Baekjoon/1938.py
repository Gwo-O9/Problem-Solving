from collections import deque

n = int(input())
graph = [list(input().strip()) for _ in range(n)]

start = []
goal = []
directions = [[0, -1], [0, 1], [-1, 0], [1, 0], [1, 1], [-1, -1], [1, -1], [-1, 1]]
direction_garo = True
visited = set()
for i in range(n):
    for j in range(n):
        if graph[i][j] == 'B':
            start.append((i, j))
            graph[i][j] = '0'
        if graph[i][j] == 'E':
            goal.append((i, j))
            graph[i][j] = '0'

if start[0][0] != start[1][0]:
    direction_garo = False
else:
    direction_garo = True

q = deque([(start, direction_garo, 0)])
visited.add(tuple(start))

while q:
    tree, direction, cnt = q.popleft()
    if tree == goal:
        print(cnt)
        exit()

    # turn
    center_x, center_y = tree[1]
    turn_check = True
    tmp = []
    for d in range(8):
        nx, ny = center_x + directions[d][0], center_y + directions[d][1]
        if not (0 <= nx < n) or not (0 <= ny < n) or not graph[nx][ny] == '0':
            turn_check = False
            break
    if turn_check:
        if direction:
            tmp.append((center_x-1, center_y))
            tmp.append((center_x,  center_y))
            tmp.append((center_x+1, center_y))
        else:
            tmp.append((center_x, center_y-1))
            tmp.append((center_x, center_y))
            tmp.append((center_x, center_y+1))
        if tuple(tmp) not in visited:
            q.append((tmp, not direction, cnt+1))
            visited.add(tuple(tmp))


    # 4 direction
    for d in range(4):
        tmp = []
        for i in range(3):
            nx, ny = tree[i][0] + directions[d][0], tree[i][1] + directions[d][1]
            if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == '0':
                tmp.append((nx, ny))
        if len(tmp) == 3 and tuple(tmp) not in visited:
            q.append((tmp, direction, cnt+1))
            visited.add(tuple(tmp))

print(0)