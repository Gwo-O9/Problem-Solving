from collections import deque

n = int(input())
balloons = list(map(int, input().split()))
q = deque([])

for i in range(n):
    q.append((balloons[i], i))

while q:
    x, index = q[0]
    print(index + 1, end=" ")
    if x > 0:
        q.append(q.popleft())
        for _ in range(x-1):
            y, index_y = q[0]
            if index_y == index:
                q.popleft()
                if not q:
                    break
                q.append(q.popleft())
                continue
            else:
                q.append(q.popleft())
    elif x < 0:
        q.appendleft(q.pop())
        for _ in range(abs(x)-1):
            y, index_y = q[-1]
            if index_y == index:
                q.pop()
                if not q:
                    break
                q.appendleft(q.pop())
                continue
            else:
                q.appendleft(q.pop())
    if (x, index) in q:
        q.remove((x, index))
