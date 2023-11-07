n = int(input())

abilities = [list(map(int, input().split())) for _ in range(n)]
visited = [False]*n
min_value = 100000000000


def dfs(size, i, n):
    global min_value, abilities
    if size == n//2:
        team_a = 0
        team_b = 0
        for j in range(n):
            for k in range(n):
                if visited[j] and visited[k]:
                    team_a += abilities[j][k]
                elif not visited[j] and not visited[k]:
                    team_b += abilities[j][k]
        min_value = min(min_value, abs(team_a - team_b))
        return
    for j in range(i, n):
        if not visited[j]:
            visited[j] = True
            dfs(size+1, j, n)
            visited[j] = False


dfs(0, 0, n)
print(min_value)
