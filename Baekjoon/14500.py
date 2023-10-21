n, m = map(int, input().split())
blocks = [list(map(int, input().split())) for _ in range(n)]
ans = 0
directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
visited = [[0]*m for _ in range(n)]

def dfs(i, j, graph, total, cnt):
    global ans
    global directions
    global n, m
    global visited
    if cnt == 4:
        ans = max(ans, total)
        return
    for d in range(4):
        nx, ny = i + directions[d][0], j + directions[d][1]
        if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == 0:
            if cnt == 2:
                visited[nx][ny] = 1
                dfs(i, j, graph, total + graph[nx][ny], cnt + 1)
                visited[nx][ny] = 0
            visited[nx][ny] = 1
            dfs(nx, ny, graph, total+graph[nx][ny], cnt + 1)
            visited[nx][ny] = 0

for i in range(n):
    for j in range(m):
        visited[i][j] = 1
        dfs(i, j, blocks, blocks[i][j], 1)
        visited[i][j] = 0

print(ans)
