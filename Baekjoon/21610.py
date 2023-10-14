from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
cmds = []
for _ in range(m):
    a, b = map(int, input().split())
    cmds.append([a,b])
directions = [[0,-1], [-1,-1], [-1,0], [-1,1], [0, 1], [1, 1], [1, 0], [1, -1]]
queue = deque() # 비 구름 위치가 들어가는 deque
#초기 세팅
queue.append([n-1,0])
queue.append([n-1, 1])
queue.append([n-2, 0])
queue.append([n-2, 1])
before = []

for i in range(m):
    visited = [[0]*n for _ in range(n)]
    length = len(queue)
    before.clear()
    for _ in range(length):
        cloud = queue.popleft()
        d, move = cmds[i][0]-1, cmds[i][1]
        x, y = cloud[0], cloud[1]
        x = (x + directions[d][0]*move) % n
        y = (y + directions[d][1]*move) % n
        queue.append([x, y])
        visited[x][y] = 1
        arr[x][y] += 1
    for _ in range(length):
        cloud = queue.popleft()
        x = cloud[0]
        y = cloud[1]
        for k in range(4):
            nx = x + directions[k*2+1][0]
            ny = y + directions[k*2+1][1]
            if 0 <= nx < n and 0 <= ny < n and arr[nx][ny] > 0:
                arr[x][y] += 1
    for j in range(n):
        for k in range(n):
            if visited[j][k] == 0 and arr[j][k] >=2:
                arr[j][k] -= 2
                queue.append([j,k])

print(sum(sum(tmp) for tmp in arr))
