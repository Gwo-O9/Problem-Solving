from collections import deque

def turn(c, direction):
    if c == "L":
        direction = (direction + 1) % 4
    else:
        direction = (direction - 1) % 4
    return direction


N = int(input())  # 보드 사이즈
K = int(input())  # 사과의 개수
board = [[0] * N for _ in range(N)]  # board 0으로 초기화
board[0][0] = 2
second = 0  # 게임이 지난 후 시간
x, y = 0, 0 # 뱀 머리의 현재 위치
op_dict = {}
queue = deque()
queue.append(0)
queue.append(0)
directions = [[-1, 0], [0, -1], [1, 0], [0, 1]]  # 0(북), 1(서), 2(남), 3(동)
d = 3  # 뱀의 최초 방향 3

for _ in range(K):
    r, c = map(int, input().split())
    board[r - 1][c - 1] = 1  # 사과가 있는 위치는 1

n = int(input())

for _ in range(n):
    a, b = input().split()
    op_dict[int(a)] = b

while True:
    second += 1  # 1초 증가
    # 바라보고 있는 방향으로 이동
    x += directions[d][0]
    y += directions[d][1]

    #뱀이 벽이나 본인 몸에 박으면 종료
    if not(0 <= x < N and 0 <= y < N) or board[x][y] == 2:
        break

    if board[x][y] == 1: #사과가 있을 때
        board[x][y] = 2 #사과가 있던 자리는 뱀이 차지
        queue.append(x) # queue에 뱀 머리 추가
        queue.append(y)
        if second in op_dict:
            d = turn(op_dict[second], d)

    elif board[x][y] == 0: #빈 공간일 때
        board[x][y] = 2 # 빈 공간은 뱀이 차지
        queue.append(x) # queue에 뱀 머리 추가
        queue.append(y)
        tailx = queue.popleft() # queue에서 뱀 꼬리 제거
        taily = queue.popleft()
        board[tailx][taily] = 0 #꼬리 빈 공간으로 갱신
        if second in op_dict:
            d = turn(op_dict[second], d)

print(second)
