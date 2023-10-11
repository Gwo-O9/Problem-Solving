from collections import deque

n = int(input()) # 맵 사이즈
directions = [[-1, 0], [0, -1], [0, 1], [1, 0]] # 북, 서, 동, 남
board = [list(map(int, input().split())) for _ in range(n)] # 맵 받기
size = 2  # 상어 크기
second = 0  # 진행 시간
queue = deque()  # BFS를 위한 queue
eaten_count = 0

# 상어 위치 찾기
for i in range(n):
    for j in range(n):
        if board[i][j] == 9:
            x, y = i, j
            board[i][j] = 0

while True:
    #초기 세팅
    is_visited = [[0]*n for _ in range(n)]
    queue.append([x, y, 0])
    is_visited[x][y] = 1
    fish = []

    while queue:
        x, y, dist = queue.popleft()
        for i in range(4):
            nx = x + directions[i][0]
            ny = y + directions[i][1]

            # 후보지에 이미 방문했거나 범위를 벗어났다면 다음 방향
            if not (0 <= nx < n and 0 <= ny < n) or is_visited[nx][ny] == 1:
                continue

            # 방문 체크
            is_visited[nx][ny] = 1
            if size > board[nx][ny] > 0:
                fish.append([dist+1, nx, ny])
            elif board[nx][ny] == 0 or board[nx][ny] == size:
                queue.append([nx, ny, dist + 1])

    if not fish:
        break

    fish.sort(key=lambda t: (t[0], t[1], t[2]))
    second += fish[0][0]
    x, y = fish[0][1], fish[0][2]
    board[x][y] = 0
    eaten_count += 1

    if eaten_count == size:
        size += 1
        eaten_count = 0

print(second)
