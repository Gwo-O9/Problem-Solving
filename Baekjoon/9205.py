from collections import deque


def can_reach(p1, p2):
    return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1]) <= 1000


def bfs(start, end, stores):
    q = deque([start])
    visited = set()

    while q:
        x, y = q.popleft()

        if can_reach((x, y), end):
            return "happy"

        for i in stores:
            if i not in visited and can_reach((x, y), i):
                visited.add(i)
                q.append(i)

    return "sad"


t = int(input())

for _ in range(t):
    n = int(input())
    start_x, start_y = map(int, input().split())
    q = deque()
    stores = []
    for i in range(1, n + 1):
        stores.append(tuple(map(int, input().split())))
    end_x, end_y = map(int, input().split())

    print(bfs((start_x, start_y), (end_x, end_y), stores))
