import heapq

n, e = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))
INF =  1000000000000
start, end = map(int, input().split())

def dijkstra(i, j):
    dist = [INF]*(n+1)
    dist[i] = 0
    hq = [(0, i)]
    while hq:
        l, node = heapq.heappop(hq)
        if l > dist[node]:
            continue
        for next_node, value in graph[node]:
            if dist[next_node] > dist[node] + value:
                dist[next_node] = dist[node] + value
                heapq.heappush(hq, (dist[next_node], next_node))
    return dist[j]

path1 = dijkstra(1, start) + dijkstra(start, end) + dijkstra(end, n)
path2 = dijkstra(1, end) + dijkstra(end, start) +dijkstra(start, n)

print(-1) if path1 >= INF and path2 >= INF else print(min(path1, path2))

