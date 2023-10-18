from collections import deque

n, m = map(int, input().split())
arr = [list(map(int, list(input().strip()))) for _ in range(n)]
q = deque([(0, 0, 1)])
directions = [[-1,0], [1,0], [0,-1], [0,1]]
result = 10002

while q:
    cur_x, cur_y, time_xy = q.popleft()
    arr[cur_x][cur_y] = 0
    for i in range(4):
        nx, ny = cur_x + directions[i][0], cur_y + directions[i][1]
        if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 1:
            arr[nx][ny] = 0
            if nx == n-1 and ny == m-1:
                result = min(time_xy+1, result)
            else:
                q.append((nx,ny, time_xy+1))
print(result)


