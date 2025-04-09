n, m = map(int, input().split())
car = list(map(int, input().split())) # x, y, d
graph = [list(map(int, input().split())) for _ in range(n)]
directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
graph[car[0]][car[1]] = 2

while True:
    r, c, first_d = car
    moved = False
    d = first_d
    for _ in range(4):
        d = (d - 1) % 4
        nx, ny = r + directions[d][0], c + directions[d][1]
        if graph[nx][ny] == 0:
            graph[nx][ny] = 2
            car = (nx, ny, d)
            moved = True
            break
    if moved:
        continue
    nx, ny = r - directions[d][0], c - directions[d][1]
    if graph[nx][ny] == 1:
        break
    graph[nx][ny] = 2
    car = (nx, ny, d)

total = 0
for i in graph:
    total += i.count(2)
print(total)

