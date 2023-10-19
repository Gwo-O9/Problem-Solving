from collections import deque

n, m = map(int, input().split())
campus = []

for _ in range(n):
    campus.append(list(map(str, input().rstrip())))

directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]

cnt = 0
do_x, do_y = -1, -1

visited = [[0]*m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if campus[i][j] == 'I':
            do_x, do_y = i, j
            visited[do_x][do_y] = 1
        if campus[i][j] == 'X':
            visited[i][j] = 1  # Directly mark 'X' tiles as visited

q = deque([(do_x, do_y)])

while q:
    x, y = q.popleft()
    for i in range(4):
        nx, ny = x + directions[i][0], y + directions[i][1]
        if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == 0:
            if campus[nx][ny] == 'P':
                cnt += 1
                visited[nx][ny] = 1
                q.append((nx,ny))
            elif campus[nx][ny] == 'O':
                visited[nx][ny] = 1
                q.append((nx, ny))

if cnt == 0:
    print("TT")
else:
    print(cnt)
