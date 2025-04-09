from itertools import combinations
import math

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
works = [x for x in range(n)]
answer = math.inf


def get_combinations():
    candidates = []
    for i in combinations(works, n//2):
        candidates.append(list(i))
    return candidates


combination_works = get_combinations()

for combination_work in combination_works:
    cnt_1 = 0
    cnt_2 = 0
    remains = []
    for i in range(n):
        if i not in combination_work:
            remains.append(i)

    for i, work1 in enumerate(combination_work):
        for j, work2 in enumerate(combination_work):
            if i == j:
                continue
            cnt_1 += graph[work1][work2]

    for i, work1 in enumerate(remains):
        for j, work2 in enumerate(remains):
            if i == j:
                continue
            cnt_2 += graph[work1][work2]

    answer = min(abs(cnt_1 - cnt_2), answer)

print(answer)
