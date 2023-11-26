n = int(input())
dists = list(map(int, input().split()))
costs = list(map(int, input().split()))

min_cost = costs[0]
total = 0

for i in range(n - 1):
    if min_cost > costs[i]:
        min_cost = costs[i]
    total += min_cost * dists[i]

print(total)
