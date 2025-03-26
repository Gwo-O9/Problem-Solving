from collections import deque

N, K = map(int, input().split())
visited = [False for _ in range(100001)]
q = deque([(N, 0)])
ans = 100002
while q:
    now, time = q.popleft()
    if now == K:
        ans = min(time, ans)
    if now + 1 <= 100000 and visited[now+1] is False:
        visited[now + 1] = True
        q.append((now+1, time+1))
    if now - 1 >= 0 and visited[now-1] is False:
        visited[now - 1] = True
        q.append((now-1, time+1))
    if 0 <= now * 2 <= 100000 and visited[now*2] is False:
        visited[now * 2] = True
        q.append((now*2, time+1))

print(ans)