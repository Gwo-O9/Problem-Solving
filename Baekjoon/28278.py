from collections import deque

s = []
n = int(input())
cmds = deque()

for _ in range(n):
    cmds.append(list(map(int, input().split())))

for i in range(n):
    cmd = cmds.popleft()
    if cmd[0] == 1:
        s.append(cmd[1])
    elif cmd[0] == 2:
        print(-1) if len(s) == 0 else print(s.pop())
    elif cmd[0] == 3:
        print(len(s))
    elif cmd[0] == 4:
        print(1) if len(s) == 0 else print(0)
    elif cmd[0] == 5:
        print(-1) if len(s) == 0 else print(s[len(s)-1])
