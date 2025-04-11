import copy
import math

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
directions = [[0, 1], [-1, 0], [0, -1], [1, 0]]
chess_pieces = []
pieces_cnt = 0
score = math.inf

for i in range(n):
    for j in range(m):
        if graph[i][j] > 0 and graph[i][j] != 6:
            chess_pieces.append((i, j, graph[i][j]))
            pieces_cnt += 1


def get_direction_candidates(d, num):
    if num == 1:
        return [directions[d]]
    if num == 2:
        return [directions[(d - 1) % 4], directions[(d + 1) % 4]]
    if num == 3:
        return [directions[d], directions[(d - 1) % 4]]
    if num == 4:
        return [directions[d], directions[(d - 1) % 4], directions[(d + 1) % 4]]
    if num == 5:
        return directions[:]



def get_count(tmp_graph):
    cnt = 0
    for i in range(n):
        cnt += tmp_graph[i].count(0)
    return cnt


def dfs(idx, tmp_graph):
    global score
    if idx == pieces_cnt:
        score = min(score, get_count(tmp_graph))
        return
    r, c, num = chess_pieces[idx]
    for i in range(4):
        tmp_graph2 = copy.deepcopy(tmp_graph)
        candidates = get_direction_candidates(i, num)
        for dr, dc in candidates:
            nr, nc = r, c
            while True:
                nr, nc = nr + dr, nc + dc
                if not (0 <= nr < n and 0 <= nc < m):
                    break # 벗어나면 break
                if tmp_graph2[nr][nc] == 6:
                    break # 방향에 상대 말 있으면 break
                if tmp_graph2[nr][nc] > 0:
                    continue # 우리 말 있으면 continue
                if tmp_graph2[nr][nc] <= 0: # 빈칸이거나 체크한 곳이면 -1로 체크 (다시 체크도 괜찮음)
                    tmp_graph2[nr][nc] = -1
        dfs(idx+1, tmp_graph2) # 갈 수 있는 방향 다 확인했으면 다음 말 체크

dfs(0, graph)
print(score)
