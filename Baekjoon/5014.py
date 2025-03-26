from collections import deque

height, start, end, up, down = map(int, input().split())
visited = [False for _ in range(height+1)]
q = deque([(start, 0)])
visited[start] = True
ans = 10000000

while q:
    now, time = q.popleft()
    if now == end:
        ans = min(ans, time)
        continue
    if now + up <= height and visited[now+up] is False:
        q.append((now+up, time+1))
        visited[now+up] = True
    if now - down > 0 and visited[now-down] is False:
        q.append((now-down, time+1))
        visited[now-down] = True

print(ans) if ans != 10000000 else print("use the stairs")
