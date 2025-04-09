from collections import deque

N, M, fuel = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
taxi_x, taxi_y = map(int, input().split())
start_end = [list(map(int, input().split())) for _ in range(M)]
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]
completed = []

# make 0-base
for i in range(M):
    for j in range(4):
        start_end[i][j] -= 1

taxi_x -= 1
taxi_y -= 1

def get_closet(t_x, t_y):
    global graph, direction, completed, start_end
    q = deque([(t_x, t_y, 0)])
    candidates = []
    visited = [[False for _ in range(N)] for _ in range(N)]
    visited[t_x][t_y] = True
    for s_x, s_y, e_x, e_y in start_end:
        if t_x == s_x and t_y == s_y and (s_x, s_y) not in completed:
            candidates.append([0, s_x, s_y, e_x, e_y])
            break

    while q:
        x, y, dist = q.popleft()
        for i in range(4):
            nx, ny = x + direction[i][0], y + direction[i][1]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and graph[nx][ny] == 0:
                visited[nx][ny] = True
                q.append((nx, ny, dist + 1))
                for s_x, s_y, e_x, e_y in start_end:
                    if s_x == nx and s_y == ny and (s_x, s_y) not in completed:
                        candidates.append([dist+1, s_x, s_y, e_x, e_y])

    if len(candidates) == 0:
        return False
    candidates.sort(key=lambda x: (x[0], x[1], x[2]))
    completed.append((candidates[0][1], candidates[0][2]))
    return candidates[0]

def carry_client(x, y, end_x, end_y):
    visited = [[False for _ in range(N)] for _ in range(N)]
    q = deque([(x, y, 0)])
    visited[x][y] = True
    while q:
        x, y, dist = q.popleft()
        for i in range(4):
            nx, ny = x + direction[i][0], y + direction[i][1]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and graph[nx][ny] == 0:
                if nx == end_x and ny == end_y:
                    return dist+1
                visited[nx][ny] = True
                q.append((nx, ny, dist + 1))
    return False


end = False
for i in range(M):
    client = get_closet(taxi_x, taxi_y)
    if not client:
        end = True
        break
    client_dist, s_x, s_y, end_x, end_y = client
    fuel -= client_dist
    if fuel < 0:
        end = True
        break
    end_dist = carry_client(s_x, s_y, end_x, end_y)
    if not end_dist:
        end = True
        break
    fuel -= end_dist
    if fuel < 0:
        end = True
        break
    taxi_x = end_x
    taxi_y = end_y
    fuel += (end_dist*2)

print(fuel) if not end else print(-1)