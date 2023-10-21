from collections import deque

number, target = map(int, input().split())
q = deque([(number, 1)])
ans = False
while q:
    x, cnt = q.popleft()
    if x > target:
        continue
    a = x*2
    b = x*10 + 1
    if a == target or b == target:
        ans = True
        print(cnt+1)
        break
    q.append((a, cnt+1))
    q.append((b, cnt+1))

if not ans:
    print(-1)
