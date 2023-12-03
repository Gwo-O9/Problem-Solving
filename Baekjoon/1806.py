import sys

input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))
i, j = 0, 0
prefix_sum = 0
ans = sys.maxsize

while True:
    if prefix_sum >= s:
        ans = min(ans, j - i)
        prefix_sum -= arr[i]
        i += 1
    elif j == n:
        break
    else:
        prefix_sum += arr[j]
        j += 1

print(0) if ans == sys.maxsize else print(ans)
