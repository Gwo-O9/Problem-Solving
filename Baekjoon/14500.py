N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
visited = [[False for _ in range(M)] for _ in range(N)]
ans = 0
directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]


def dfs(graph, i, j, cnt, value):
    global ans
    global visited
    if cnt == 4:
        ans = max(ans, value)
        return

    for d in range(4):
        nx, ny = i + directions[d][0], j + directions[d][1]
        if not (0 <= nx < N) or not (0 <= ny < M) or visited[nx][ny] is True:
            continue
        if cnt == 2:
            visited[nx][ny] = True
            dfs(graph, i, j, cnt + 1, value + graph[nx][ny])
            visited[nx][ny] = False
        visited[nx][ny] = True
        dfs(graph, nx, ny, cnt + 1, value + graph[nx][ny])
        visited[nx][ny] = False


for i in range(N):
    for j in range(M):
        visited[i][j] = True
        dfs(graph, i, j, 1, graph[i][j])
        visited[i][j] = False

print(ans)
