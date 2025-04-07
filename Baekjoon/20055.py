from collections import deque
n, k = map(int, input().split())
A = deque(list(map(int, input().split())))
robots = deque([0 for _ in range(n)])
time = 0

while True:
    time += 1

    # 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
    A.rotate()
    robots.rotate()
    robots[n-1] = 0
    # 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
    # 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
    for i in range(n-2, -1, -1):
        if A[i+1] > 0 and robots[i] > 0 and robots[i+1] == 0:
            robots[i+1] = robots[i]
            robots[i] = 0
            A[i+1] -= 1
    # 이동했으니 또 없애줘야 함
    robots[n-1] = 0
    # 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    if robots[0] == 0 and A[0] > 0:
        robots[0] = 1
        A[0] -= 1
    # 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
    if A.count(0) >= k:
        break

print(time)

