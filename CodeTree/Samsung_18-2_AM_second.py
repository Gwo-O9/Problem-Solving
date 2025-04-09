from collections import deque

n, L, R = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def get_egg_group(x, y, visited):
    q = deque([(x, y)])
    path = [(x, y)]
    while q:
        r, c = q.popleft()
        for d in directions:
            nr, nc = r + d[0], c + d[1]
            if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc]:
                if L <= abs(graph[nr][nc] - graph[r][c]) <= R:
                    path.append((nr, nc))
                    q.append((nr, nc))
                    visited[nr][nc] = True

    return path

time = 0
while True:
    egg_groups = []
    visited = [[False for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                visited[i][j] = True
                egg_groups.append(get_egg_group(i, j, visited))

    if len(egg_groups) == n*n:
        break

    for egg_group in egg_groups:
        count = len(egg_group)
        total = 0
        for r, c in egg_group:
            total += graph[r][c]
        mean = total//count
        for r, c in egg_group:
            graph[r][c] = mean

    time += 1



print(time)

# 9 3 16
# 69 58 9 32 25 73 16 64 39
# 8 14 49 80 71 84 18 21 44
# 27 2 33 99 2 13 47 47 36
# 97 47 42 25 41 30 21 83 22
# 47 44 94 71 88 26 93 8 24
# 42 74 67 50 96 52 5 68 83
# 37 47 11 58 59 98 37 5 39
# 40 65 36 34 26 41 20 27 86
# 20 12 28 76 62 11 89 18 50