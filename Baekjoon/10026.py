from collections import deque

n = int(input())
pic = [list(map(str, input().rstrip())) for _ in range(n)]
directions = [[1, 0], [-1, 0], [0, -1], [0, 1]]


def cal_area(pic, n):
    visited = [[0]*n for _ in range(n)]
    cnt = 0
    for j in range(n):
        for k in range(n):
            if visited[j][k] == 1:
                continue
            q = deque([(j, k)])
            visited[j][k] = 1
            while q:
                x, y = q.popleft()
                for i in range(4):
                    dx, dy = x + directions[i][0], y + directions[i][1]
                    if 0 <= dx < n and 0 <= dy < n and pic[dx][dy] == pic[x][y] and visited[dx][dy] == 0:
                        visited[dx][dy] = 1
                        q.append((dx, dy))
            cnt += 1
    return cnt


def cal_area_as_blindness(pic, n):
    visited = [[0]*n for _ in range(n)]
    cnt = 0
    for j in range(n):
        for k in range(n):
            if visited[j][k] == 1:
                continue
            q = deque([(j, k)])
            visited[j][k] = 1
            while q:
                x, y = q.popleft()
                for i in range(4):
                    dx, dy = x + directions[i][0], y + directions[i][1]
                    if 0 <= dx < n and 0 <= dy < n:
                        if (pic[dx][dy] == pic[x][y] or (pic[dx][dy] == 'R' and pic[x][y] == 'G') or (pic[dx][dy] == 'G' and pic[x][y] == 'R')) and visited[dx][dy] == 0:
                            visited[dx][dy] = 1
                            q.append((dx, dy))
            cnt += 1
    return cnt

print(cal_area(pic, n), end=" ")
print(cal_area_as_blindness(pic, n))
