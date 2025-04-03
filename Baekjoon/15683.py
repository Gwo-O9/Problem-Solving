import copy

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
cctvs = []
ans = 70
mode = [
    [],
    [[0], [1], [2], [3]],
    [[0, 2], [1, 3]],
    [[0, 1], [1, 2], [2, 3], [3, 0]],
    [[0, 1, 2], [0, 1, 3], [0, 2, 3], [1, 2, 3]],
    [[0, 1, 2, 3]]
]
directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]

for i in range(n):
    for j in range(m):
        if 1 <= graph[i][j] <= 5:
            cctvs.append((i, j, graph[i][j])) # x, y, cctv 종류


def dfs(count, tmp_graph):
    global cctvs, ans
    if count == len(cctvs):
        ans = min(ans, safe_count(tmp_graph))
        return
    temp = copy.deepcopy(tmp_graph)
    x, y, value = cctvs[count]
    for i in mode[value]:
        for j in i:
            nx = x
            ny = y
            while True:
                nx += directions[j][0]
                ny += directions[j][1]
                if not (0 <= nx < n) or not (0 <= ny < m) or temp[nx][ny] == 6:
                    break
                else:
                    temp[nx][ny] = 7
        dfs(count+1, temp)
        temp = copy.deepcopy(tmp_graph)

def safe_count(graph):
    global n, m
    cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                cnt += 1
    return cnt

dfs(0, graph)
print(ans)