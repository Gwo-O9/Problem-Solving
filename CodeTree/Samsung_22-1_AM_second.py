from collections import deque

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]


def get_groups():
    visited = [[False for _ in range(n)] for _ in range(n)]
    candidates = [[] for _ in range(n**2+1)]
    group_graph = [[0 for _ in range(n)] for _ in range(n)]
    tmp = 0
    for i in range(n):
        for j in range(n):
            if visited[i][j]:
                continue
            tmp += 1
            visited[i][j] = True
            q = deque([(i, j)])
            cnt = 1
            value = graph[i][j]
            group_graph[i][j] = tmp
            while q:
                r, c = q.popleft()
                for d in directions:
                    nr, nc = r + d[0], c + d[1]
                    if 0 <= nr < n and 0 <= nc < n:
                        if graph[nr][nc] == value and not visited[nr][nc]:
                            visited[nr][nc] = True
                            cnt += 1
                            q.append((nr, nc))
                            group_graph[nr][nc] = tmp
            candidates[tmp] = [value, cnt]

    return candidates, group_graph


def get_combinations(group_graph):
    combinations = [[0 for _ in range(n**2+1)] for _ in range(n**2+1)]
    visited = [[False for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j]:
                continue
            value = group_graph[i][j]
            q = deque([(i, j)])
            visited[i][j] = True
            while q:
                r, c = q.popleft()
                for d in directions:
                    nr, nc = r + d[0], c + d[1]
                    if 0 <= nr < n and 0 <= nc < n:
                        if group_graph[nr][nc] == value:
                            if not visited[nr][nc]:
                                visited[nr][nc] = True
                                q.append((nr, nc))
                        if group_graph[nr][nc] != value:
                            combinations[value][group_graph[nr][nc]] += 1
                            continue

    return combinations


def get_score(combinations, groups):  # 완료
    ret = 0
    visited = set()
    for i in range(n**2+1):
        for j in range(n**2+1):
            if i == j:
                continue
            if combinations[i][j] > 0:
                if (i, j) not in visited:
                    visited.add((i, j))
                    visited.add((j, i))
                    value1, cnt1 = groups[i]
                    value2, cnt2 = groups[j]
                    ret += ((cnt1 + cnt2) * value1 * value2 * combinations[i][j])
    return ret


def rotate_grid():
    new_graph = [[0 for _ in range(n)] for _ in range(n)]
    mid = n // 2
    for i in range(0, n, mid + 1):
        for j in range(0, n, mid + 1):
            for r in range(mid):
                for c in range(mid):
                    new_graph[i + c][j + mid - 1 - r] = graph[i + r][j + c]

    for i in range(n):
        new_graph[mid][i] = graph[i][mid]
        new_graph[i][mid] = graph[mid][n - 1 - i]

    return new_graph


ans = 0
for i in range(4):
    groups, group_graph = get_groups()
    combination = get_combinations(group_graph)
    ans += get_score(combination, groups)
    graph = rotate_grid()

print(ans)
