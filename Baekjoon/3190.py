from collections import deque

def turn(c, direction):
    if c == "L":
        direction = (direction + 1) % 4
    else:
        direction = (direction - 1) % 4
    return direction


N = int(input())  # 보드의 크기
K = int(input())  # 사과의 개수
directions = [[-1, 0], [0, -1], [1, 0], [0, 1]]  # 0(북), 1(서), 2(남), 3(동)
d = 3
graph = [[0 for _ in range(N)] for _ in range(N)]
for _ in range(K):
    r, c = map(int, input().split())
    graph[r - 1][c - 1] = 1  # 사과
action_num = int(input())
operations = {}
for _ in range(action_num):
    x, o = input().split()
    operations[int(x)] = o
graph[0][0] = 2
x, y = 0, 0
q = deque([(0, 0)])
second = 0

while True:
    second += 1

    x += directions[d][0]
    y += directions[d][1]

    if not (0 <= x < N) or not (0 <= y < N) or graph[x][y] == 2:  # 종료 조건
        break

    if graph[x][y] == 1:
        graph[x][y] = 2
        q.append((x, y))
    else:
        graph[x][y] = 2
        q.append((x,y))
        bx, by = q.popleft()
        graph[bx][by] = 0

    if second in operations:
        d = turn(operations[second], d)

print(second)
