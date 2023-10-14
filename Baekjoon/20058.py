from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()
n, q = map(int, input().split())
size = 2**n
ice_field = [list(map(int, input().split())) for _ in range(size)]
magics = list(map(int, input().split()))
directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
visited = [[0] * size for _ in range(size)]

def rotate_ice(graph, l):
    temp_field = [[0] * size for _ in range(size)]
    for x in range(0, size, 2**l):
        for y in range(0, size, 2**l):
            for i in range(2**l):
                for j in range(2**l):
                    temp_field[x + j][y + 2**l - 1 - i] = graph[x + i][y + j]
    return temp_field

def count_bfs(graph, i, j):
    q = deque([(i, j)])
    cnt = 0
    while q:
        r, c = q.popleft()
        for dx, dy in directions:
            nr, nc = r + dx, c + dy
            if 0 <= nr < size and 0 <= nc < size and not visited[nr][nc] and graph[nr][nc]:
                visited[nr][nc] = 1
                q.append((nr, nc))
                cnt += 1
    return cnt

for magic in magics:
    ice_field = rotate_ice(ice_field, magic)
    neighbor_counts = [[sum(1 for dx, dy in directions if 0 <= x + dx < size and 0 <= y + dy < size and ice_field[x + dx][y + dy] > 0) for y in range(size)] for x in range(size)]
    for i in range(size):
        for j in range(size):
            if neighbor_counts[i][j] < 3 and ice_field[i][j]:
                ice_field[i][j] -= 1

ice = sum(sum(row) for row in ice_field)
max_ice = max((count_bfs(ice_field, i, j) for i in range(size) for j in range(size) if ice_field[i][j] and not visited[i][j]), default=0)

print(ice)
print(max_ice)
