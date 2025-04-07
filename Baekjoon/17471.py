import math
import itertools
import copy
from collections import deque


def is_all_connected(cities, near_info, n):
    if len(cities) == 1:
        return True

    q = deque([cities[0]])
    visited = [0] * (n + 1)
    while q:
        x = q.popleft()
        visited[x] = 1
        for city in near_info[x]:
            if city - 1 in cities and visited[city-1] == 0:
                q.append(city-1)
                visited[city-1] = 1
    cnt = visited.count(1)

    if cnt == len(cities):
        return True
    else:
        return False


n = int(input())
population = list(map(int, input().split()))
cities = [i for i in range(n)]
near_info = []
for _ in range(n):
    near = list(map(int, input().split()))
    if near[1:]:
        near_info.append(near[1:])
    else:
        near_info.append([-1])
ans = math.inf
candidates = []
for i in range(1, (n // 2 + 1)):
    one = itertools.combinations(cities, i)
    for on in one:
        two = copy.deepcopy(cities)
        for o in on:
            two.remove(o)
        candidates.append((list(on), two))

for candidate in candidates:
    a, b = candidate
    a_sum, b_sum = 0, 0
    if is_all_connected(a, near_info, n) and is_all_connected(b, near_info, n):
        for city in a:
            a_sum += population[city]
        for city in b:
            b_sum += population[city]
        diff = abs(a_sum - b_sum)

        ans = min(diff, ans)

print(ans) if ans != math.inf else print(-1)
