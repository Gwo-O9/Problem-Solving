from collections import deque

n, m, k = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(n)]
nutrition = [[5 for _ in range(n)] for _ in range(n)]
trees = [[deque() for _ in range(n)] for _ in range(n)]
directions = [[0, 1], [0, -1], [1, 0], [-1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]]
for _ in range(m):
    x, y, z = map(int, input().split())
    trees[x - 1][y - 1].append(z)

for _ in range(k):
    # 봄 / 여름
    for i in range(n):
        for j in range(n):
            if trees[i][j]:
                temp = []
                dead_trees = 0
                while trees[i][j]:
                    age = trees[i][j].popleft()
                    if nutrition[i][j] - age >= 0:
                        nutrition[i][j] -= age
                        temp.append(age + 1)
                    else:
                        dead_trees += (age // 2)
                trees[i][j] = deque(temp)
                nutrition[i][j] += dead_trees

    # 가을
    for i in range(n):
        for j in range(n):
            for age in trees[i][j]:
                if age % 5 == 0:
                    for d in range(8):
                        nx, ny = i + directions[d][0], j + directions[d][1]
                        if (0 <= nx < n) and (0 <= ny < n):
                            trees[nx][ny].appendleft(1)

    # 겨울
    for i in range(n):
        for j in range(n):
            nutrition[i][j] += A[i][j]

ans = 0
for i in range(n):
    for j in range(n):
        ans += len(trees[i][j])

print(ans)
