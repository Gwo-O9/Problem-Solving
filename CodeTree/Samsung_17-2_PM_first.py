from collections import deque

# idx -> 위 0, 오른쪽 2, 왼쪽 6
one = deque(list(map(int, input().strip())))
two = deque(list(map(int, input().strip())))
three = deque(list(map(int, input().strip())))
four = deque(list(map(int, input().strip())))
chairs = [one, two, three, four]
k = int(input())
cmds = [list(map(int, input().split())) for _ in range(k)]

for cmd in cmds:
    target, d = cmd
    target -= 1
    left = chairs[target][6]
    right = chairs[target][2]
    chairs[target].rotate(d)
    tmp = target
    tmp_d = d*(-1)
    while tmp < 3:
        if right != chairs[tmp+1][6]:
            right = chairs[tmp+1][2]
            chairs[tmp+1].rotate(tmp_d)
            tmp += 1
            tmp_d *= -1
        else:
            break

    tmp = target
    tmp_d = d*(-1)
    while tmp > 0:
        if left != chairs[tmp-1][2]:
            left = chairs[tmp-1][6]
            chairs[tmp-1].rotate(tmp_d)
            tmp -= 1
            tmp_d *= -1
        else:
            break

score = 0
for i, chair in enumerate(chairs):
    if chair[0] == 1:
        if i == 0:
            score += 1
        if i == 1:
            score += 2
        if i == 2:
            score += 4
        if i == 3:
            score += 8

print(score)
