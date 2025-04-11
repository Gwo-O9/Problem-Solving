n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
score = 0


def dfs(i, j, cnt, value, visited):
    global score
    if cnt == 4:
        score = max(value, score)
        return

    for d in directions:
        nx, ny = i + d[0], j + d[1]
        if 0 <= nx < n and 0 <= ny < m and (nx, ny) not in visited:
            visited.append((nx, ny))
            dfs(nx, ny, cnt + 1, value + graph[nx][ny], visited)
            if cnt == 2:
                dfs(i, j, cnt + 1, value + graph[nx][ny], visited)
            visited.remove((nx, ny))


for i in range(n):
    for j in range(m):
        dfs(i, j, 1, graph[i][j], [(i, j)])
print(score)