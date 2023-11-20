n = int(input())
seq = list(map(int, input().split()))
dpl = [1] * (n + 1)
dpr = [1] * (n + 1)
dp = [0] * (n + 1)

for i in range(n):
    for j in range(i):
        if seq[i] > seq[j]:
            dpl[i] = max(dpl[i], dpl[j] + 1)

for i in range(n - 1, -1, -1):
    for j in range(n - 1, i, -1):
        if seq[i] > seq[j]:
            dpr[i] = max(dpr[i], dpr[j] + 1)

for i in range(n):
    dp[i] = dpr[i] + dpl[i] - 1 # 중간 수 겹치니 -1

print(max(dp))
