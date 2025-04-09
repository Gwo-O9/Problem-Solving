n = int(input())
graph = [[0 for _ in range(n)] for _ in range(n)]
students = [list(map(int, input().split())) for _ in range(n * n)]
directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
love_list = [[] for _ in range(n*n+1)]
for student in students:
    love_list[student[0]] = student[1:]
score = 0


def get_love_and_empty_cnt(now, i, j):
    love_cnt = 0
    empty_cnt = 0
    for d in directions:
        nr, nc = i + d[0], j + d[1]
        if 0 <= nr < n and 0 <= nc < n:
            if graph[nr][nc] in love_list[now]:
                love_cnt += 1
            elif graph[nr][nc] == 0:
                empty_cnt += 1
    return (love_cnt, empty_cnt)


def get_score():
    global score
    for i in range(n):
        for j in range(n):
            cnt = 0
            for d in directions:
                nr, nc = i + d[0], j + d[1]
                if 0 <= nr < n and 0 <= nc < n and graph[nr][nc] in love_list[graph[i][j]]:
                    cnt += 1

            if cnt == 1:
                score += 1
            if cnt == 2:
                score += 10
            if cnt == 3:
                score += 100
            if cnt == 4:
                score += 1000


for student in students:
    candidates = []
    for i in range(n):
        for j in range(n):
            if graph[i][j] > 0:
                continue

            love_cnt, empty_cnt = get_love_and_empty_cnt(student[0], i, j)
            candidates.append([i, j, love_cnt, empty_cnt])

    candidates.sort(key=lambda x: (-x[2], -x[3], x[0], x[1]))
    r, c, qwe, rty = candidates[0]
    graph[r][c] = student[0]

get_score()
print(score)