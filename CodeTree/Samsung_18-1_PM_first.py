n = int(input())
graph = [[False for _ in range(101)] for _ in range(101)]
directions = [[0, 1], [-1, 0], [0, -1], [1, 0]] #오, 위, 왼, 아

def draw(x, y, path):
    global graph
    graph[x][y] = True
    for d in path:
        x, y = x + directions[d][0], y + directions[d][1]
        graph[x][y] = True

def get_score():
    score = 0
    for i in range(100):
        for j in range(100):
            if graph[i][j] and graph[i+1][j] and graph[i][j+1] and graph[i+1][j+1]:
                score += 1
    return score

for _ in range(n):
    x, y, d, g = map(int, input().split())
    path = [d]
    for i in range(g):
        length = len(path)
        for j in range(length-1, -1, -1):
            path.append((path[j]+1)%4)
    draw(x, y, path)

print(get_score())