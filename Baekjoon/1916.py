import heapq

c_num = int(input())
b_num = int(input())
graph = [[] for _ in range(c_num + 1)]
for _ in range(b_num):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
start, end = map(int, input().split())
INF = 1000000000000


def dijkstra(start, end):
    dist = [INF] * (c_num + 1)
    dist[start] = 0
    hq = [(0, start)]
    while hq:
        a, node = heapq.heappop(hq)
        if a > dist[node]:
            continue
        for next_node, value in graph[node]:
            if dist[next_node] > dist[node] + value:
                dist[next_node] = dist[node] + value
                heapq.heappush(hq, (dist[next_node], next_node))
    return dist[end]


print(dijkstra(start, end))
