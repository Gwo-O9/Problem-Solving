import sys

input = sys.stdin.readline
n, m = map(int, input().split())
sum_v = [0] * (n + 10)
arr = list(map(int, input().split()))
remains = [0] * m
sum_v[0] = arr[0]
cnt = 0
remains[sum_v[0] % m] += 1
for i in range(1, n):
    sum_v[i] = sum_v[i - 1] + arr[i]
    remains[sum_v[i] % m] += 1

# 나머지가 같은 prefix_sum의 경우의 수 (x Combination 2 = x*(x-1)/2)
for i in range(m):
    cnt += remains[i] * (remains[i] - 1) // 2
print(cnt + remains[0])
