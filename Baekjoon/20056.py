N, M, K = map(int, input().split())
fire_balls = []
directions = [[-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1]]
for _ in range(M):
    r, c, m, s, d = map(int, input().split())
    fire_balls.append((r-1, c-1, m, s, d))

for _ in range(K):
    new_fire_balls = []
    collision_check = [[[] for _ in range(N)] for _ in range(N)]
    for fire_ball in fire_balls:
        r, c, m, s, d = fire_ball
        nr, nc = (r + directions[d][0]*s) % N, (c + directions[d][1]*s) % N
        collision_check[nr][nc].append((nr, nc, m, s, d))

    for i in range(N):
        for j in range(N):
            if len(collision_check[i][j]) > 1:
                m_sum, s_sum = 0, 0
                is_all_even = True
                is_all_odd = True
                for fire in collision_check[i][j]:
                    _, _, m, s, d = fire
                    m_sum += m
                    s_sum += s
                    if d % 2 == 0:
                        is_all_odd = False
                    else:
                        is_all_even = False
                if m_sum // 5 <= 0:
                    continue
                if (is_all_odd and not is_all_even) or (not is_all_odd and is_all_even):
                    for k in range(4):
                        new_fire_balls.append((i, j, m_sum//5, s_sum//len(collision_check[i][j]), k*2))
                else:
                    for k in range(4):
                        new_fire_balls.append((i, j, m_sum // 5, s_sum // len(collision_check[i][j]), k * 2 - 1))
            elif len(collision_check[i][j]) == 1:
                new_fire_balls.append(collision_check[i][j][0])

    fire_balls = new_fire_balls


ans = 0
for fire_ball in fire_balls:
    ans += fire_ball[2]

print(ans)

