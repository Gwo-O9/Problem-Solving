from collections import defaultdict

r, c, k = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(3)]

time = 0
while True:
    r_len = len(graph)
    c_len = len(graph[0])
    if 0 <= r-1 < r_len and 0 <= c-1 < c_len and graph[r-1][c-1] == k:
        print(time)
        exit()

    if time > 100:
        print(-1)
        exit()

    garo = False
    if r_len >= c_len:
        garo = True

    new_graph = [[] for _ in range(r_len)]
    if garo:
        for i in range(r_len):
            num_dict = defaultdict(list)
            for j in range(c_len):
                if graph[i][j] > 0:
                    if num_dict[graph[i][j]]:
                        num_dict[graph[i][j]] += 1
                    else:
                        num_dict[graph[i][j]] = 1
            for x, cnt in sorted(num_dict.items(), key = lambda x: (x[1], x[0])):
                new_graph[i].append(x)
                new_graph[i].append(cnt)
        max_val = -1
        for i in range(r_len):
            max_val = max(max_val, len(new_graph[i]))

        for i in range(r_len):
            new_graph[i].extend([0]*(max_val - len(new_graph[i])))

        graph = new_graph

    else:
        new_graph = [[] for _ in range(c_len)]
        transposed = list(map(list, zip(*graph)))
        for i in range(c_len):
            num_dict = defaultdict(int)
            for j in range(r_len):
                if transposed[i][j] > 0:
                    if num_dict[transposed[i][j]]:
                        num_dict[transposed[i][j]] += 1
                    else:
                        num_dict[transposed[i][j]] = 1
            for x, cnt in sorted(num_dict.items(), key = lambda x: (x[1], x[0])):
                new_graph[i].append(x)
                new_graph[i].append(cnt)
        max_val = -1
        for i in range(c_len):
            max_val = max(max_val, len(new_graph[i]))

        for i in range(c_len):
            new_graph[i].extend([0]*(max_val - len(new_graph[i])))

        transposed = list(map(list, zip(*new_graph)))

        graph = transposed

    time += 1
