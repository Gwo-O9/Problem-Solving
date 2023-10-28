from collections import deque

n = int(input())
tree = [[] for _ in range(n+1)]
ans = [0]*(n+1)
for _ in range(n-1):
    x, y = map(int, input().split())
    tree[x].append(y)
    tree[y].append(x)

q = deque()
q.append(1)
visited = [0]*(n+1)
visited[1] = 1

while q:
    x = q.popleft()
    for node in tree[x]:
        if visited[node] == 0:
            visited[node] = 1
            q.append(node)
            ans[node] = x

for i in range(2,n+1):
    print(ans[i])
