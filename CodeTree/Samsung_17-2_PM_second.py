import math

max_v = -math.inf
min_v = math.inf

n = int(input())
numbers = list(map(int, input().split()))
len(numbers)
operators = list(map(int, input().split())) # +, -, *

def dfs(idx, operators, now):
    global max_v, min_v
    if idx == n:
        max_v = max(max_v, now)
        min_v = min(min_v, now)
        return

    for i in range(3):
        if operators[i] > 0:
            operators[i] -= 1
            if i == 0:
                dfs(idx+1, operators, now + numbers[idx])
            if i == 1:
                dfs(idx+1, operators, now - numbers[idx])
            if i == 2:
                dfs(idx+1, operators, now * numbers[idx])
            operators[i] += 1

dfs(1, operators, numbers[0])
print(min_v, end=" ")
print(max_v)