from collections import deque

N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
magics = [list(map(int, input().split())) for _ in range(M)]
start_x, start_y = N // 2, N // 2
directions = [[], (-1, 0), (1, 0), (0, -1), (0, 1)]  # 1~4: 상하좌우
tornado_direction = [(0, -1), (1, 0), (0, 1), (-1, 0)]  # ← ↓ → ↑
score = 0


def make_path():
    path = []
    x, y = start_x, start_y
    d = 0
    dist = 1
    while True:
        for _ in range(2):  # 한 거리당 두 방향 반복
            for _ in range(dist):
                x += tornado_direction[d][0]
                y += tornado_direction[d][1]
                if x < 0 or y < 0:
                    return path
                path.append((x, y))
            d = (d + 1) % 4
        dist += 1


path = make_path()


def destroy(d, s):
    nx, ny = start_x, start_y
    for _ in range(s):
        nx += directions[d][0]
        ny += directions[d][1]
        if 0 <= nx < N and 0 <= ny < N:
            graph[nx][ny] = 0


def graph_to_list():
    result = []
    for x, y in path:
        if graph[x][y] != 0:
            result.append(graph[x][y])
    return result


def list_to_graph(lst):
    for i, (x, y) in enumerate(path):
        graph[x][y] = lst[i] if i < len(lst) else 0


def arrangement():
    lst = graph_to_list()
    list_to_graph(lst)


def bomb():
    global score
    lst = graph_to_list()
    new_lst = []
    i = 0
    exploded = False
    while i < len(lst):
        j = i
        while j < len(lst) and lst[i] == lst[j]:
            j += 1
        if j - i >= 4:
            score += lst[i] * (j - i)
            exploded = True
        else:
            new_lst.extend(lst[i:j])
        i = j
    list_to_graph(new_lst)
    return exploded


def arrangement2():
    lst = graph_to_list()
    new_lst = []
    i = 0
    while i < len(lst):
        j = i
        while j < len(lst) and lst[i] == lst[j]:
            j += 1
        new_lst.append(j - i)
        new_lst.append(lst[i])
        i = j
    list_to_graph(new_lst)


for d, s in magics:
    destroy(d, s)
    arrangement()
    while bomb():
        arrangement()
    arrangement2()

print(score)
