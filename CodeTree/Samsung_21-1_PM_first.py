n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
cmds = [list(map(int, input().split())) for _ in range(m)]
proteins = [(n-1, 0), (n-1, 1), (n - 2, 0), (n - 2, 1)]
directions = [[], [0, 1], [-1, 1], [-1, 0], [-1, -1], [0, -1], [1, -1], [1, 0], [1, 1]]
cross_directions = [[-1, -1], [1, 1], [-1, 1], [1, -1]]
for cmd in cmds:
    d, p = cmd  # d = 이동 방향, p = 이동 칸 수

    new_proteins = []
    for protein in proteins:
        r, c = protein
        nr, nc = (r + directions[d][0] * p) % n, (c + directions[d][1] * p) % n
        graph[nr][nc] += 1
        new_proteins.append((nr, nc))

    for protein in new_proteins:
        r, c = protein
        for cd in cross_directions:
            nr, nc = r + cd[0], c + cd[1]
            if 0 <= nr < n and 0 <= nc < n and graph[nr][nc] > 0:
                graph[r][c] += 1

    proteins.clear()
    for i in range(n):
        for j in range(n):
            if (i, j) not in new_proteins and graph[i][j] >= 2:
                graph[i][j] -= 2
                proteins.append((i, j))

total = 0
for i in range(n):
    for j in range(n):
        total += graph[i][j]

print(total)