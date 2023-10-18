from collections import deque

n = int(input())

a, b = map(int,input().split())

m = int(input())

relationships = [[0]*n for _ in range(n)]

q = deque([(a-1, 0)])

result = 10000000

visited = [[0]*n for _ in range(n)]

for _ in range(m):
    temp1, temp2 = map(int, input().split())
    relationships[temp1-1][temp2-1] = relationships[temp2-1][temp1-1] = 1
    
while q:
    p, chon = q.popleft()
    for i in range(n):
        if i == p:
            continue
        if relationships[p][i] == 1 and visited[p][i] == 0:
            if i == b-1:
                result = min(result, chon+1)
            else:
                q.append((i, chon+1))
                visited[p][i] = visited[i][p] = 1

if result == 10000000:
    print(-1)
else:
    print(result)
