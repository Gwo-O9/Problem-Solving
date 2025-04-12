T = int(input())


def in_range(x, y):
    if 0 <= x < n and 0 <= y < n:
        return True
    return False


for test_case in range(1, T + 1):
    n = int(input())
    mid = n // 2
    x, y = 0, 0
    graph = [[0 for _ in range(n)] for _ in range(n)]
    visited = [[False for _ in range(n)] for _ in range(n)]
    directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    d = 0
    i = 2
    graph[0][0] = 1

    while True:
        nx, ny = x + directions[d][0], y + directions[d][1]
        if not in_range(nx, ny) or visited[nx][ny]:
            d = (d + 1) % 4
            nx, ny = x + directions[d][0], y + directions[d][1]
            if not in_range(nx, ny) or visited[nx][ny]:
                break
        graph[nx][ny] = i
        visited[x][y] = True

        x, y = nx, ny
        i += 1

    print(f"#{test_case}")

    for i in range(n):
        for j in range(n):
            print(graph[i][j], end=" ")
        print()
