# 3:00
n = int(input())
N = n**2
graph = [[0 for _ in range(n)] for _ in range(n)]
students = [[] for _ in range(N+1)]
go = []
for _ in range(N):
    tmp = list(map(int, input().split()))
    students[tmp[0]] = tmp[1:]
    go.append(tmp[0])
directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]

for s in go:
    candidates = []
    max_count = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] != 0:
                continue
            cnt = 0
            empty = 0
            for d in directions:
                nx, ny = i + d[0], j + d[1]
                if 0 <= nx < n and 0 <= ny < n:
                    if graph[nx][ny] in students[s]:
                        cnt += 1
                    if graph[nx][ny] == 0:
                        empty += 1

            if max_count == cnt:
                candidates.append([i, j, empty])
            elif cnt > max_count:
                candidates = [[i, j, empty]]
                max_count = cnt

    candidates.sort(key=lambda x: (-x[2], x[0], x[1]))
    graph[candidates[0][0]][candidates[0][1]] = s

happy = 0
for i in range(n):
    for j in range(n):
        stud_num = graph[i][j]
        cnt = 0
        for d in directions:
            nx, ny = i + d[0], j + d[1]
            if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] in students[stud_num]:
                cnt += 1
        if cnt != 0:
            happy += (10**(cnt-1))

print(happy)