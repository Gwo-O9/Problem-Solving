n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
sand_out = 0  # answer
x, y = n//2, n//2 # 현재 위치

left = [(-2,0,0.02),(-1,-1,0.1),(-1,0,0.07),(-1,1,0.01),(0,-2,0.05),(1,-1,0.1),(1,0,0.07),(1,1,0.01),(2,0,0.02)]
right = [(x,-y,z) for x,y,z in left]
up = [(y,-x,z) for x,y,z in left]
down = [(-y,x,z) for x,y,z in left]
directions = [left, down, right, up]
d = 0
move_directions = [[0,-1],[1,0],[0,1],[-1,0]]

for i in range(n*2-1):
    if i == n*2-2:
        distance = i//2
    else:
        distance = i//2 + 1
    for _ in range(distance):
        x += move_directions[d][0]
        y += move_directions[d][1]
        total_moved_sand = 0
        for dir in directions[d]:
            nx = x + dir[0]
            ny = y + dir[1]
            moved_sand = int(arr[x][y]*dir[2])
            if 0 <= nx < n and 0 <= ny < n:
                arr[nx][ny] += moved_sand
            else:
                sand_out += moved_sand
            total_moved_sand += moved_sand
        alpha_x, alpha_y = x + move_directions[d][0], y + move_directions[d][1]
        if 0 <= alpha_x < n and 0 <= alpha_y < n:
            arr[alpha_x][alpha_y] += (arr[x][y] - total_moved_sand)
        else:
            sand_out += (arr[x][y] - total_moved_sand)
        arr[x][y] = 0
    d = (d + 1) % 4

print(sand_out)
