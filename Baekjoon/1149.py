n = int(input())
paint_cost = [0]*n

for i in range(n):
    paint_cost[i] = list(map(int, input().split()))

for i in range(1, n):
    paint_cost[i][0] += min(paint_cost[i-1][1], paint_cost[i-1][2])
    paint_cost[i][1] += min(paint_cost[i-1][0], paint_cost[i-1][2])
    paint_cost[i][2] += min(paint_cost[i-1][0], paint_cost[i-1][1])

print(min(paint_cost[n-1]))

