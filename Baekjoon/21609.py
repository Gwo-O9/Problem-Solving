from collections import deque
from copy import deepcopy

# 15:47 - 16:42
N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
# -1 은 검은색 0 은 무지개색 -2 는 내가 지운 블록
score = 0

def apply_gravity():
    for j in range(N):
        for i in range(N - 2, -1, -1):  # 밑에서 두 번째 줄부터 시작
            if graph[i][j] >= 0:
                x = i
                while True:
                    if x + 1 == N or graph[x + 1][j] != -2:
                        break
                    x += 1
                if x != i:
                    graph[x][j] = graph[i][j]
                    graph[i][j] = -2


def rotate_reverse_90():
    global graph
    new_graph = deepcopy(graph)
    for i in range(N):
        for j in range(N):
            new_graph[N-1-j][i] = graph[i][j]

    return new_graph

while True:
    candidates_group = []
    visited = [[False for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            color = graph[i][j]
            if color >= 1:
                rainbow = 0
                candidates = [[i, j]]
                q = deque([(i, j)])
                visited[i][j] = True
                rainbow_visited = [[False for _ in range(N)] for _ in range(N)]
                while q:
                    x, y = q.popleft()
                    for dx, dy in directions:
                        nx, ny = x + dx, y + dy
                        if 0 <= nx < N and 0 <= ny < N and ((not visited[nx][ny] and graph[nx][ny] == color) or (not rainbow_visited[nx][ny] and graph[nx][ny] == 0)):
                            candidates.append([nx, ny])
                            q.append((nx, ny))
                            if graph[nx][ny] == 0:
                                rainbow += 1
                                rainbow_visited[nx][ny] = True
                            else:
                                visited[nx][ny] = True
                if len(candidates) <= 1:
                    continue
                candidates.append([i, j, rainbow])
                candidates_group.append(candidates)

    if len(candidates_group) == 0:
        break

    candidates_group.sort(key=lambda x: (-len(x), -x[-1][2], -x[-1][0], -x[-1][1]))

    for idx, c in enumerate(candidates_group[0]):
        if idx == len(candidates_group[0]) - 1:
            break

        x, y = c
        graph[x][y] = -2

    score += (len(candidates_group[0])-1)**2

    apply_gravity()

    graph = rotate_reverse_90()

    apply_gravity()

print(score)