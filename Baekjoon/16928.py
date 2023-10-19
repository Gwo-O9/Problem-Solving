from collections import deque

cube = [0]*100
visited = [0]*100
n, m = map(int, input().split())
for _ in range(n+m):
    a, b = map(int, input().split())
    cube[a-1] = b-1
q = deque([(0, 0)])
ans = 1000
visited[0] = 1

while q:
    x, cnt = q.popleft()
    if cnt >= ans:
        break
    for i in range(1, 7):
        nx = x + i
        if 0 <= nx < 100 and visited[nx] == 0:
            if nx == 99:
                ans = min(cnt+1, ans)
            elif cube[nx] != 0:
                visited[cube[nx]] = 1
                q.append((cube[nx], cnt+1))
            else:
                visited[nx] = 1
                q.append((nx, cnt+1))
print(ans)
