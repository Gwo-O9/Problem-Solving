from collections import deque
cogwheels = [list(map(int, input().strip())) for _ in range(4)]
q_list = []
for i in range(4):
    q_list.append(deque(cogwheels[i]))
def left(idx, direction):
    if idx < 0:
        return
    if q_list[idx][2] != q_list[idx+1][6]:
        left(idx-1, -direction) # 그 옆도 확인, 반대 방향으로 회전하니까 -
        q_list[idx].rotate(direction) # 현재 톱니 회전

def right(idx, direction):
    if idx > 3:
        return
    if q_list[idx-1][2] != q_list[idx][6]:
        right(idx+1, -direction)
        q_list[idx].rotate(direction)

n = int(input())

for i in range(n):
    num, d = map(int, input().split())
    num = num - 1
    left(num-1, -d)
    right(num+1, -d)
    q_list[num].rotate(d)

score = 0
for i in range(4):
    if q_list[i][0] == 1:
        score += 2 ** i
print(score)