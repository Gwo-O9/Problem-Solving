import sys
input = lambda: sys.stdin.readline().rstrip()

directions = [[-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1]]
n, m, k = map(int, input().split())
fire_balls = [list(map(int, input().split())) for _ in range(m)] # r, c m: 질량, s: 속략, d: 방향
map = [[[] for _ in range(n)] for _ in range(n)]

for _ in range(k): # k 번 마법을 쓴다.
    # 1. 파이어 볼 모두 이동
    while fire_balls:
        cr, cc, cm, cs, cd = fire_balls.pop()
        nr = (cr-1 + directions[cd][0]*cs) % n
        nc = (cc-1 + directions[cd][1]*cs) % n
        map[nr][nc].append([cm, cs, cd])

    # 2. 2개 이상 파이어 볼이 있는 칸 처리
    for i in range(n):
        for j in range(n):
            if len(map[i][j]) > 1:
                sum_m, sum_s, cnt_odd, cnt_even, cnt = 0, 0, 0, 0, len(map[i][j])
                for k in range(cnt):
                    cm, cs, cd = map[i][j].pop()
                    sum_m += cm
                    sum_s += cs
                    if cd % 2 == 0:
                        cnt_even += 1
                    else:
                        cnt_odd += 1
                if cnt_even == cnt or cnt_odd == cnt:
                    dir = [0, 2, 4, 6]
                else:
                    dir = [1, 3, 5, 7]
                if sum_m//5:
                    for d in dir:
                        fire_balls.append([i, j, sum_m//5, sum_s//cnt, d])

            # 3. 1개인 경우 처리
            if len(map[i][j]) == 1:
                fire_balls.append([i, j] + (map[i][j].pop()))


print(sum(q[2] for q in fire_balls))
