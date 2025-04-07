n = int(input())
blue = [[0 for _ in range(4)] for _ in range(6)] # 실제로는 가로임
green = [[0 for _ in range(4)] for _ in range(6)]
score = 0

# 1. 블록 놓는 로직
# 2. 점수 체크
# 3. 점수 체크 후 블록 내리기
# 4. 0-1 범위에 블록 있으면 맨 아래 블록 삭제
# 5. 블록 내리기 (3과 동일)
# 6. 남은 블록 갯수 체크
def get_score(graph):
    global score
    i = 5
    while i >= 2:
        if graph[i].count(1) == 4:
            score += 1
            graph[i] = [0, 0, 0, 0]
            for j in range(i-1, -1, -1):
                for k in range(4):
                    graph[j+1][k] = graph[j][k]
            graph[0] = [0, 0, 0, 0]
        else:
            i -= 1


def set_block(t, x, y, color, graph):
    if color == "green":
        if t == 1:
            row = 0
            while row < 6 and graph[row][y] == 0:
                row += 1
            graph[row - 1][y] = 1

        elif t == 2:  # 가로 블럭 (y, y+1)
            row = 0
            while row < 6 and graph[row][y] == 0 and graph[row][y + 1] == 0:
                row += 1
            graph[row - 1][y] = 1
            graph[row - 1][y + 1] = 1

        elif t == 3:  # 세로 블럭 (x, x+1)
            row = 0
            while row + 1 < 6 and graph[row][y] == 0 and graph[row + 1][y] == 0:
                row += 1
            graph[row - 1][y] = 1
            graph[row][y] = 1

    elif color == "blue":
        if t == 1:
            col = 0
            while col < 6 and graph[col][x] == 0:
                col += 1
            graph[col - 1][x] = 1

        elif t == 2:  # 가로 블럭 → blue에서는 세로
            col = 0
            while col + 1 < 6 and graph[col][x] == 0 and graph[col + 1][x] == 0:
                col += 1
            graph[col - 1][x] = 1
            graph[col][x] = 1

        elif t == 3:  # 세로 블럭 → blue에서는 가로 (x, x+1)
            col = 0
            while col < 6 and graph[col][x] == 0 and graph[col][x + 1] == 0:
                col += 1
            graph[col - 1][x] = 1
            graph[col - 1][x + 1] = 1


def check_one_two_row(graph):
    cnt = 0
    for i in range(2):
        if graph[i].count(1) > 0:
            cnt += 1
    for _ in range(cnt):
        for i in range(5, 0, -1):
            for j in range(4):
                graph[i][j] = graph[i-1][j]
        graph[0] = [0, 0, 0, 0]




for _ in range(n):
    t, x, y = map(int, input().split())
    set_block(t, x, y, "blue", blue)
    set_block(t, x, y, "green", green)
    get_score(blue)
    get_score(green)
    check_one_two_row(blue)
    check_one_two_row(green)

count = 0
for i in range(6):
    count += green[i].count(1) + blue[i].count(1)

print(score)
print(count)
