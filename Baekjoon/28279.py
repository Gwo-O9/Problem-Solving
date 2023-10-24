from collections import deque

n = int(input())
cmds = []
for _ in range(n):
    cmds.append(list(map(int, input().split())))
q = deque()

for cmd in cmds:
    if cmd[0] == 1:
        q.appendleft(cmd[1])
    if cmd[0] == 2:
        q.append(cmd[1])
    if cmd[0] == 3:
        print(-1) if len(q) == 0 else print(q.popleft())
    if cmd[0] == 4:
        print(-1) if len(q) == 0 else print(q.pop())
    if cmd[0] == 5:
        print(len(q))
    if cmd[0] == 6:
        print(1) if len(q) == 0 else print(0)
    if cmd[0] == 7:
        print(-1) if len(q) == 0 else print(q[0])
    if cmd[0] == 8:
        print(-1) if len(q) == 0 else print(q[-1])
