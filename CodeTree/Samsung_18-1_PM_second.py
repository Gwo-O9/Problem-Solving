from itertools import combinations
import math
from collections import deque

n, m = map(int, input().split())
people = []
hospitals = []
graph = [list(map(int, input().split())) for _ in range(n)]
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            people.append((i, j))
        if graph[i][j] == 2:
            hospitals.append((i, j))

min_dist = math.inf
directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]


def find_hospital(hos_x, hos_y, x, y):
    q = deque([(x, y, 0)])
    visited = [[False for _ in range(n)] for _ in range(n)]
    visited[x][y] = True
    while q:
        r, c, dist = q.popleft()
        if (r, c) == (hos_x, hos_y):
            return dist
        for d in directions:
            nr, nc = r + d[0], c + d[1]
            if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc]:
                q.append((nr, nc, dist + 1))
                visited[nr][nc] = True

len_hospitals = len(hospitals)
len_people = len(people)
all_dist = [[0 for _ in range(len_people)] for _ in range(len_hospitals)]
for i, hospital in enumerate(hospitals):
    for j, person in enumerate(people):
        all_dist[i][j] = find_hospital(hospital[0], hospital[1], person[0], person[1])

pick_numbers = combinations([x for x in range(len_hospitals)], m)

for numbers in pick_numbers:
    dist_of_each = [math.inf for _ in range(len_people)]
    for x in numbers:
        for y in range(len_people):
            dist_of_each[y] = min(dist_of_each[y], all_dist[x][y])
    min_dist = min(sum(dist_of_each), min_dist)


print(min_dist)


