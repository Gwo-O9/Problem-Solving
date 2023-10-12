n = int(input())
students = n*n

love = [list(map(int, input().split())) for _ in range(students)]

room = [[0]*n for _ in range(n)]
directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
result = 0
dict = {}
# 1. 가장 왼쪽 윗 칸 (1,1) 가장 오른쪽 아래 (n,n)
# 2. 인접은 | r1 - r2 | + | c1 - c2| = 1 (4방)
# 3. 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸
# 4. 위를 만족하는 칸이 여러 개라면 인접한 칸 중 비어있는 칸이 가장 많은 경우
# 5. 위도 여러 개인 경우 행 번호가 가장 낮은 곳
# 6. 위도 여러 개인 경우 열 번호가 가장 낮은 곳

# 계획: 각 학생 별로 사람이 있는 자리를 제외한 모든 자리를 확인하여 좋아하는 학생, 빈 칸, 행, 열을 저장한다.
###### 좋아하는 학생 수 / 빈칸 수 / 행 / 렬 순서로 정렬 후 젤 위에 것 뽑아서 그 자리에
###### 마지막 인접한 칸에 좋아하는 학생의 수를 구하고 만족도를 구한다.

for i in range(n*n):
    q = []
    cand = []
    for j in range(n):
        for k in range(n):
            if room[j][k] != 0:
                continue
            like = 0
            empty = 0
            x = 0
            y = 0
            for d in range(4):
                x = j + directions[d][0]
                y = k + directions[d][1]
                if not (0 <= x < n and 0 <= y < n):
                    continue
                if room[x][y] == 0:
                    empty += 1
                elif room[x][y] in love[i][1:]:
                    like += 1
            cand.append([like, empty, j, k])
    cand.sort(key = lambda x: (-x[0], -x[1], x[2], x[3]))
    a, b = cand[0][2], cand[0][3]
    room[a][b] = love[i][0]
    dict.update({room[a][b]:i})

tmp = 0
for i in range(n):
    for j in range(n):
        cnt = 0
        for d in range(4):
            x = i + directions[d][0]
            y = j + directions[d][1]
            if not (0 <= x < n and 0 <= y < n):
                continue
            elif room[x][y] in love[dict.get(room[i][j])][1:]:
                cnt += 1
        if cnt == 1:
            result += 1
        elif cnt == 2:
            result += 10
        elif cnt == 3:
            result += 100
        elif cnt == 4:
            result += 1000
        tmp += 1

print(result)


