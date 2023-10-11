N, M = map(int, input().split()) # 배열 크기
r, c, d = map(int, input().split()) # 로봇 청소기 첫 위치 (r,c), 방향 d
room = [list(map(int, input().split())) for _ in range(N)] # 방
cleaned = 0
directions = [[-1, 0],[0,1],[1,0],[0,-1]]
# d = 0(북), 1(동), 2(남), 3(서)
# 방이 0인 경우 청소되지 않은 빈칸, 1은 벽, 2는 청소된 공간

while True:
    # 1. 현재 칸이 청소되지 않은 경우 청소 함
    if room[r][c] == 0:
        room[r][c] = 2
        cleaned += 1

    check_4directions = 0
    for _ in range(4):
        d = (d + 3) % 4
        check_r = r+directions[d][0]
        check_c = c+directions[d][1]
        if 0 <= check_r < N and 0 <= check_c < M and room[check_r][check_c] == 0:
            r, c = check_r, check_c
            break
        check_4directions += 1

    if check_4directions == 4:
        check_r = r - directions[d][0]
        check_c = c - directions[d][1]
        if not (0 <= check_r < N and 0 <= check_c < M) or room[check_r][check_c] == 1:
            break
        r, c = check_r, check_c
#결과 출력
print(cleaned)
