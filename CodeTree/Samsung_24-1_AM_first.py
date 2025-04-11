from copy import deepcopy
from collections import deque

K, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(5)]
numbers = deque(list(map(int, input().split())))
directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]


def rotate_90(i, j, graph):
    new_graph = deepcopy(graph)
    new_graph[i-1][j-1] = graph[i+1][j-1]
    new_graph[i-1][j] = graph[i][j-1]
    new_graph[i-1][j+1] = graph[i-1][j-1]
    new_graph[i][j+1] = graph[i-1][j]
    new_graph[i+1][j+1] = graph[i-1][j+1]
    new_graph[i+1][j] = graph[i][j+1]
    new_graph[i+1][j-1] = graph[i+1][j+1]
    new_graph[i][j-1] = graph[i+1][j]
    return new_graph


def get_value(graph):
    visited = [[False for _ in range(5)] for _ in range(5)]
    total = 0
    for r in range(5):
        for c in range(5):
            if graph[r][c] == 0:
                continue
            if not visited[r][c]:
                cnt = 1
                visited[r][c] = True
                q = deque([(r, c)])
                while q:
                    x, y = q.popleft()
                    for d in directions:
                        nx, ny = x + d[0], y + d[1]
                        if 0 <= nx < 5 and 0 <= ny < 5 and not visited[nx][ny] and graph[nx][ny] == graph[r][c]:
                            q.append((nx, ny))
                            visited[nx][ny] = True
                            cnt += 1
                if cnt >= 3:
                    total += cnt
    return total


def remove_value(graph):
    visited = [[False for _ in range(5)] for _ in range(5)]
    total = 0
    for r in range(5):
        for c in range(5):
            if graph[r][c] == 0:
                continue
            if not visited[r][c]:
                path = [(r, c)]
                cnt = 1
                visited[r][c] = True
                q = deque([(r, c)])
                while q:
                    x, y = q.popleft()
                    for d in directions:
                        nx, ny = x + d[0], y + d[1]
                        if 0 <= nx < 5 and 0 <= ny < 5 and not visited[nx][ny] and graph[nx][ny] == graph[r][c]:
                            q.append((nx, ny))
                            visited[nx][ny] = True
                            path.append((nx, ny))
                            cnt += 1
                if cnt >= 3:
                    total += cnt
                    for x, y in path:
                        graph[x][y] = 0

    if total > 0:
        return True, total
    else:
        return False, 0


def fill(graph):
    for j in range(5):
        for i in range(4, -1, -1):
            if graph[i][j] == 0:
                graph[i][j] = numbers.popleft()


for _ in range(K):
    ans = 0
    candidates = []
    for i in range(1, 4):
        for j in range(1, 4):
            rotated_graph = deepcopy(graph)
            for k in range(3):
                rotated_graph = rotate_90(i, j, rotated_graph)
                value = get_value(rotated_graph)
                candidates.append((value, k, i, j, rotated_graph))

    candidates.sort(key=lambda x: (-x[0], x[1], x[3], x[2]))
    value, k, x, y, candidate_graph = candidates[0]
    if value == 0:
        exit()

    _, cnt = remove_value(candidate_graph)
    ans += cnt

    fill(candidate_graph)

    while True:
        boolean, cnt = remove_value(candidate_graph)
        if not boolean:
            break
        else:
            ans += cnt
            fill(candidate_graph)

    graph = candidate_graph

    print(ans, end=" ")
