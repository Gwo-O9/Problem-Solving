from collections import deque

N, M, T = map(int, input().split())
line = []

def remove():
    global line
    have_to_remove = set()  # (x, y) 좌표
    for i in range(N):
        for j in range(M):
            if line[i][j] == 0:
                continue
            if line[i][(j + 1) % M] == line[i][j]:
                have_to_remove.add((i, j))
                have_to_remove.add((i, (j + 1) % M))
            if line[i][(j - 1 + M) % M] == line[i][j]:
                have_to_remove.add((i, j))
                have_to_remove.add((i, (j - 1 + M) % M))
    for i in range(1, N):
        for j in range(M):
            if line[i][j] == 0:
                continue
            if line[i - 1][j] == line[i][j]:
                have_to_remove.add((i, j))
                have_to_remove.add((i - 1, j))
    if len(have_to_remove) == 0:
        return False
    else:
        for x, y in have_to_remove:
            line[x][y] = 0
        return True


for i in range(N):
    line.append(deque(list(map(int, input().split()))))

for _ in range(T):
    x, d, k = map(int, input().split())
    total = 0
    count = 0
    for i in range(1, N+1):
        j = i - 1
        total += sum(line[j])
        count += M - line[j].count(0)
        if i % x == 0:
            if d == 0:
                for _ in range(k):
                    line[j].rotate(1)
            else:
                for _ in range(k):
                    line[j].rotate(-1)

    if not remove():
        if count != 0:
            mean = total / count
            for i in range(N):
                for j in range(M):
                    if line[i][j] == 0:
                        continue
                    else:
                        if line[i][j] > mean:
                            line[i][j] -= 1
                        elif line[i][j] < mean:
                            line[i][j] += 1

ans = 0
for i in range(N):
    ans += sum(line[i])

print(ans)
