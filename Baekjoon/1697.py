from collections import deque
n, k = map(int, input().split())

result = 10000000
visited = [0]*1000000
q = deque([(n, 0)])

while q:
    cur, time = q.popleft()
    if cur == k:
        result = time
        break
    if result != 10000000 and time > result:
        break
    walk_back, walk_front = cur - 1, cur + 1
    warp = cur*2
    visited[cur] = 1
    if 100001 > walk_back >= 0 and visited[walk_back] == 0:
        if walk_back == k:
            result = min(result, time+1)
            visited[walk_back] = 1
        else:
            visited[walk_back] = 1
            q.append((walk_back, time+1))
    if 100001 > walk_front >= 0 and visited[walk_front] == 0:
        if walk_front == k:
            result = min(result, time+1)
            visited[walk_front] = 1
        else:
            visited[walk_front] = 1
            q.append((walk_front, time+1))
    if 100001 > warp >= 0 and visited[warp] == 0:
        if warp == k:
            result = min(result, time+1)
            visited[warp] = 1
        else:
            visited[warp] = 1
            q.append((warp, time+1))


print(result)
