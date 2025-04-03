r, c, k = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(3)]
r -= 1
c -= 1
time = 0
for _ in range(101):
    r_size = len(graph)
    c_size = max(len(row) for row in graph)

    if 0 <= r < r_size and 0 <= c < c_size and graph[r][c] == k:
        break

    sorted = []
    # r 연산
    if r_size >= c_size:
        for i in graph:
            tmp = []
            candidates = []
            dict = {}
            for j in i:
                if j != 0:
                    if j in dict:
                        dict[j] += 1
                    else:
                        dict[j] = 1
            for key, value in dict.items():
                candidates.append([key, value])
            candidates.sort(key=lambda x:(x[1], x[0]))
            for x, y in candidates:
                tmp.append(x)
                tmp.append(y)
            sorted.append(tmp)
        max_length = max(len(row) for row in sorted)
        for row in sorted:
            row.extend([0] * (max_length - len(row)))  # 부족한 부분 0으로 채우기
        graph = sorted

    else:
        for i in range(c_size):
            tmp = []
            candidates = []
            dict = {}
            for j in range(r_size):
                if graph[j][i] != 0:
                    if graph[j][i] in dict:
                        dict[graph[j][i]] += 1
                    else:
                        dict[graph[j][i]] = 1
            for key, value in dict.items():
                candidates.append([key, value])
            candidates.sort(key=lambda x: (x[1], x[0]))
            for x, y in candidates:
                tmp.append(x)
                tmp.append(y)
            sorted.append(tmp)

        max_length = max(len(col) for col in sorted)
        for col in sorted:
            col.extend([0] * (max_length - len(col)))  # 부족한 부분 0으로 채우기

        graph = list(map(list, zip(*sorted)))
    time += 1

print(time) if time < 101 else print(-1)